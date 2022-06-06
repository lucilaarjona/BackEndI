package com.dh.dao.impl;

import com.dh.dao.ConfiguracionJDBC;
import com.dh.dao.GeneradorDeSentencias;
import com.dh.dao.IDao;
import com.dh.model.Domicilio;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDaoH2 implements IDao<Domicilio> {

    private ConfiguracionJDBC configuracionJDBC;
    private Logger logger = Logger.getLogger(DomicilioDaoH2.class);
    private List<String> campos = List.of("calle", "numero", "localidad", "provincia");

    public DomicilioDaoH2() throws Exception {
        this.configuracionJDBC = new ConfiguracionJDBC();
    }

    public DomicilioDaoH2(ConfiguracionJDBC configuracionJDBC) throws Exception {
        if (configuracionJDBC == null) {
            throw new Exception("¡Sin configuración de JDBC no hay DAO!");
        }
        this.configuracionJDBC = configuracionJDBC;
    }

    @Override
    public Domicilio consultarPorId(Integer id) throws SQLException {logger.debug("Iniciando método 'consultarPorId()'");
        Connection connection = configuracionJDBC.obtenerConexionConBD();
        PreparedStatement preparedStatement = connection.prepareStatement(GeneradorDeSentencias.generarSelectPorId("domicilios"));
        preparedStatement.setInt(1, id);
        ResultSet result = preparedStatement.executeQuery();
        Domicilio domicilio = new Domicilio();

        if (result.next()) {
            domicilio.setDomicilioID(result.getInt("id"));
            domicilio.setCalle(result.getString("calle"));
            domicilio.setNumero(result.getInt("numero"));
            domicilio.setLocalidad(result.getString("localidad"));
            domicilio.setProvincia(result.getString("provincia"));
        }

        connection.close();
        logger.debug("Terminó la ejecución del método 'consultarPorId()' con éxito");
        return domicilio;
    }

    @Override
    public List<Domicilio> consultarTodos() throws SQLException {
        logger.debug("Iniciando método 'consultarTodos()'");
        Connection connection = configuracionJDBC.obtenerConexionConBD();
        PreparedStatement preparedStatement = connection.prepareStatement(GeneradorDeSentencias.generarSelectAll("domicilios"));
        ResultSet results = preparedStatement.executeQuery();
        List<Domicilio> domicilios = new ArrayList<>();

        while (results.next()) {
            Domicilio domicilio = new Domicilio(
                    results.getInt("id"),
                    results.getString("calle"),
                    results.getInt("numero"),
                    results.getString("localidad"),
                    results.getString("provincia")
            );
            domicilios.add(domicilio);
        }
        logger.debug("Terminó la ejecución del método 'consultarTodos()' con éxito");
        return domicilios;
    }

    @Override
    public Domicilio insertarNuevo(Domicilio domicilio) throws Exception {
        Connection connection = configuracionJDBC.obtenerConexionConBD();
        PreparedStatement preparedStatement = connection.prepareStatement(
                GeneradorDeSentencias.generarInsert("domicilios", campos),
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, domicilio.getCalle());
        preparedStatement.setInt(2, domicilio.getNumero());
        preparedStatement.setString(3, domicilio.getLocalidad());
        preparedStatement.setString(4, domicilio.getProvincia());
        preparedStatement.execute();
        ResultSet keys = preparedStatement.getGeneratedKeys();
        if (keys.next()) {
            domicilio.setDomicilioID(keys.getInt("id"));
        }
        connection.close();
        logger.debug("Terminó la ejecución del método 'insertarNuevo()' con éxito");
        return domicilio;
    }

    @Override
    public void borrarTodos() throws SQLException {
        logger.debug("Iniciando método 'borrarTodos()'");
        Connection connection = configuracionJDBC.obtenerConexionConBD();
        PreparedStatement preparedStatement = connection.prepareStatement(GeneradorDeSentencias.generarDeleteAll("domicilios"));
        preparedStatement.execute();
        connection.close();
        logger.debug("Terminó la ejecución del método 'borrarTodos()' con éxito");
    }

    @Override
    public Boolean actualizar(Domicilio domicilio) throws Exception {
        logger.debug("Iniciando método 'actualizar()'");
        if (domicilio == null) throw new Exception("El domicilio no puede ser null");
        Connection connection = configuracionJDBC.obtenerConexionConBD();
        PreparedStatement preparedStatement = connection.prepareStatement(GeneradorDeSentencias.generarUpdate("domicilios", campos));
        preparedStatement.setString(1, domicilio.getCalle());
        preparedStatement.setInt(2, domicilio.getNumero());
        preparedStatement.setString(3, domicilio.getLocalidad());
        preparedStatement.setString(4, domicilio.getProvincia());
        preparedStatement.setInt(5, domicilio.getDomicilioID());
        Boolean seActualizo = preparedStatement.execute();
        connection.close();
        logger.debug("Terminó la ejecución del método 'actualizar()' con éxito");
        return seActualizo;
    }
}
