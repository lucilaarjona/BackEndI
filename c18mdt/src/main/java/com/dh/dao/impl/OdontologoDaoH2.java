package com.dh.dao.impl;

import com.dh.dao.ConfiguracionJDBC;
import com.dh.dao.GeneradorDeSentencias;
import com.dh.dao.IDao;
import com.dh.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private ConfiguracionJDBC configuracionJDBC;
    private Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    private List<String> campos = List.of("nombre", "apellido", "numeroMatricula");

    public OdontologoDaoH2() {
        configuracionJDBC = new ConfiguracionJDBC();
    }

    public OdontologoDaoH2(ConfiguracionJDBC configuracionJDBC) throws Exception {
        if (configuracionJDBC == null) {
            throw new Exception("¡Sin configuración de JDBC no hay DAO!");
        }
        this.configuracionJDBC = configuracionJDBC;
    }

    @Override
    public Odontologo consultarPorId(Integer id) throws SQLException, Exception {
        logger.debug("Iniciando método 'consultarPorId()'");

        if (id == null) throw new Exception("El id no puede ser null");

        Connection connection = configuracionJDBC.obtenerConexionConBD();
        PreparedStatement preparedStatement = connection.prepareStatement(GeneradorDeSentencias.generarSelectPorId("odontologos"));
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Odontologo odontologo = new Odontologo();

        if (resultSet.next()) {
            odontologo.setId(resultSet.getString("id"));
            odontologo.setNombre(resultSet.getString("nombre"));
            odontologo.setApellido(resultSet.getString("apellido"));
            odontologo.setMatricula(resultSet.getString("numeroMatricula"));
        } else {
            throw new Exception("No existe ningun odontologo con ese ID");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        logger.debug("Terminó la ejecución del método 'consultarPorId()' con éxito");
        return odontologo;
    }

    @Override
    public List<Odontologo> consultarTodos() throws SQLException {
        logger.debug("Iniciando método 'consultarTodos()'");

        Connection connection = configuracionJDBC.obtenerConexionConBD();
        PreparedStatement preparedStatement = connection.prepareStatement(GeneradorDeSentencias.generarSelectAll("odontologos"));
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Odontologo> odontologos = new ArrayList<>();

        while (resultSet.next()) {
            Odontologo paciente = new Odontologo(
                    resultSet.getString("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    resultSet.getString("numeroMatricula")
            );
            odontologos.add(paciente);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        logger.debug("Terminó la ejecución del método 'consultarTodos()' con éxito");
        return odontologos;
    }

    @Override
    public Odontologo insertarNuevo(Odontologo odontologo) throws Exception {
        logger.debug("Iniciando método 'insertarNuevo()'");

        if (odontologo == null) throw new Exception("El odontologo no puede ser null");

        Connection connection = configuracionJDBC.obtenerConexionConBD();
        PreparedStatement preparedStatement = connection.prepareStatement(
                GeneradorDeSentencias.generarInsert("odontologos", campos),
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, odontologo.getNombre());
        preparedStatement.setString(2, odontologo.getApellido());
        preparedStatement.setString(3, odontologo.getMatricula());
        preparedStatement.execute();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            odontologo.setId(generatedKeys.getString("id"));
        }

        preparedStatement.close();
        connection.close();

        logger.debug("Terminó la ejecución del método 'insertarNuevo()' con éxito");
        return odontologo;
    }

    @Override
    public Boolean actualizar(Odontologo odontologo) throws Exception {
        logger.debug("Iniciando método 'actualizar()'");

        if (odontologo == null) throw new Exception("El odontologo no puede ser null");
        if (odontologo.getId() == null) throw new Exception("El odontologo debe tener un id");

        Connection connection = configuracionJDBC.obtenerConexionConBD();
        PreparedStatement preparedStatement = connection.prepareStatement(GeneradorDeSentencias.generarUpdate("odontologos", campos));

        preparedStatement.setString(1, odontologo.getNombre());
        preparedStatement.setString(2, odontologo.getApellido());
        preparedStatement.setString(3, odontologo.getMatricula());
        preparedStatement.setString(4, odontologo.getId());

        Boolean seActualizo = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        connection.close();

        logger.debug("Terminó la ejecución del método 'actualizar()' con éxito");
        return seActualizo;
    }

    @Override
    public void borrarTodos() throws SQLException {
        logger.debug("Iniciando método 'borrarTodos()'");
        Connection connection = configuracionJDBC.obtenerConexionConBD();
        PreparedStatement preparedStatement = connection.prepareStatement(GeneradorDeSentencias.generarDeleteAll("odontologos"));

        preparedStatement.execute();

        preparedStatement.close();
        connection.close();
        logger.debug("Terminó la ejecución del método 'borrarTodos()' con éxito");
    }
}
