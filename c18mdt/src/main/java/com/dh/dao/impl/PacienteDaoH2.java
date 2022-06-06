package com.dh.dao.impl;

import com.dh.dao.ConfiguracionJDBC;
import com.dh.dao.GeneradorDeSentencias;
import com.dh.dao.IDao;
import com.dh.model.Domicilio;
import com.dh.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {

    private ConfiguracionJDBC configuracionJDBC;
    private Logger logger = Logger.getLogger(PacienteDaoH2.class);
    private List<String> campos = List.of("nombre", "apellido", "dni", "fechaIngreso", "domicilioID");

    public PacienteDaoH2() {
        this.configuracionJDBC = new ConfiguracionJDBC();
    }

    public PacienteDaoH2(ConfiguracionJDBC configuracionJDBC) throws Exception {
        if (configuracionJDBC == null) {
            throw new Exception("¡Sin configuración de JDBC no hay DAO!");
        }
        this.configuracionJDBC = configuracionJDBC;
    }

    @Override
    public Paciente consultarPorId(Integer id) throws Exception {
        logger.debug("Iniciando método 'consultarPorId()'");
        if (id == null) throw new Exception("El id no puede ser null");
        Connection connection = configuracionJDBC.obtenerConexionConBD();
        PreparedStatement preparedStatement = connection.prepareStatement(GeneradorDeSentencias.generarSelectPorId("pacientes"));
        preparedStatement.setInt(1, id);
        ResultSet result = preparedStatement.executeQuery();
        Paciente paciente = new Paciente();

        if (result.next()) {
            paciente.setPacienteID(result.getInt("id"));
            paciente.setNombre(result.getString("nombre"));
            paciente.setApellido(result.getString("apellido"));
            paciente.setDni(result.getInt("dni"));
            paciente.setFechaIngreso(result.getDate("fechaIngreso"));
            paciente.setDomicilio(new Domicilio(result.getInt("domicilioID")));
        } else {
            throw new Exception("No existe ningun paciente con ese ID");
        }

        connection.close();
        logger.debug("Terminó la ejecución del método 'consultarPorId()' con éxito");
        return paciente;
    }

    @Override
    public List<Paciente> consultarTodos() throws SQLException {
        logger.debug("Iniciando método 'consultarTodos()'");
        Connection connection = configuracionJDBC.obtenerConexionConBD();
        PreparedStatement preparedStatement = connection.prepareStatement(GeneradorDeSentencias.generarSelectAll("pacientes"));
        ResultSet results = preparedStatement.executeQuery();
        List<Paciente> pacientes = new ArrayList<>();

        while (results.next()) {
            Paciente paciente = new Paciente(
                    results.getInt("id"),
                    results.getString("nombre"),
                    results.getString("apellido"),
                    results.getInt("dni"),
                    results.getDate("fechaIngreso"),
                    new Domicilio(results.getInt("domicilioID"))
            );
            pacientes.add(paciente);
        }
        logger.debug("Terminó la ejecución del método 'consultarTodos()' con éxito");
        return pacientes;
    }

    @Override
    public Paciente insertarNuevo(Paciente paciente) throws Exception {
        logger.debug("Iniciando método 'insertarNuevo()'");
        if (paciente == null) throw new Exception("El paciente no puede ser null");
        Connection connection = configuracionJDBC.obtenerConexionConBD();
        PreparedStatement preparedStatement = connection.prepareStatement(
                GeneradorDeSentencias.generarInsert("pacientes", campos),
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, paciente.getNombre());
        preparedStatement.setString(2, paciente.getApellido());
        preparedStatement.setInt(3, paciente.getDni());
        preparedStatement.setDate(4, paciente.getFechaIngreso());
        preparedStatement.setInt(5, paciente.getDomicilio().getDomicilioID());
        preparedStatement.execute();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            paciente.setPacienteID(generatedKeys.getInt("id"));
        }
        connection.close();
        logger.debug("Terminó la ejecución del método 'insertarNuevo()' con éxito");
        return paciente;
    }

    @Override
    public void borrarTodos() throws SQLException {
        logger.debug("Iniciando método 'borrarTodos()'");
        Connection connection = configuracionJDBC.obtenerConexionConBD();
        PreparedStatement preparedStatement = connection.prepareStatement(GeneradorDeSentencias.generarDeleteAll("pacientes"));
        preparedStatement.execute();
        connection.close();
        logger.debug("Terminó la ejecución del método 'borrarTodos()' con éxito");
    }

    @Override
    public Boolean actualizar(Paciente paciente) throws Exception {
        logger.debug("Iniciando método 'actualizar()'");
        if (paciente == null) throw new Exception("El paciente no puede ser null");
        Connection connection = configuracionJDBC.obtenerConexionConBD();
        PreparedStatement preparedStatement = connection.prepareStatement(GeneradorDeSentencias.generarUpdate("pacientes", campos));
        preparedStatement.setString(1, paciente.getNombre());
        preparedStatement.setString(2, paciente.getApellido());
        preparedStatement.setInt(3, paciente.getDni());
        preparedStatement.setDate(4, paciente.getFechaIngreso());
        preparedStatement.setInt(5, paciente.getDomicilio().getDomicilioID());
        preparedStatement.setInt(6, paciente.getPacienteID());
        Boolean seActualizo = preparedStatement.executeUpdate() > 0;
        connection.close();
        logger.debug("Terminó la ejecución del método 'actualizar()' con éxito");
        return seActualizo;
    }
}
