package name.com.dh.clinica.dao.impl;

import name.com.dh.clinica.dao.IDao;
import name.com.dh.clinica.model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOH2 implements IDao<Paciente> {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/pacientes";
    private final static String DB_USER = "";
    private final static String DB_PASSWORD = "";
    @Override

    public Paciente guardar(Paciente paciente) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO pacientes VALUES (?,?,?,?,?,?)");
            preparedStatement.setLong(1, paciente.getId());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getNombre());
            preparedStatement.setString(4, paciente.getDni());
            preparedStatement.setString(5, paciente.getFechaingreso());
            preparedStatement.setString(6, paciente.getDomicilio());


            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return paciente;
    }

    @Override
    public void eliminar(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM PACIENTES where id=?");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Paciente buscar(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Paciente paciente = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT * FROM PACIENTES where id=?");
            preparedStatement.setLong(1, id);

            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                Long idPaciente = result.getLong("id");
                String apellido = result.getString("apellido");
                String nombrePaciente = result.getString("nombre");
                String dniPaciente = result.getString("dni");
                String fechaIngresoPaciente = result.getString("fechaIngreso");
                String domicilioPaciente = result.getString("domicilio");

                paciente = new Paciente( idPaciente, apellido, nombrePaciente,dniPaciente, fechaIngresoPaciente, domicilioPaciente);

            }

            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Paciente> pacientes = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT * FROM pacientes");

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                    Long idPaciente = result.getLong("id");
                    String apellido = result.getString("apellido");
                    String nombrePaciente = result.getString("nombre");
                    String dniPaciente = result.getString("dni");
                    String fechaIngresoPaciente = result.getString("fechaIngreso");
                    String domicilioPaciente = result.getString("domicilio");
                    Paciente paciente = new Paciente( idPaciente, apellido, nombrePaciente,dniPaciente, fechaIngresoPaciente, domicilioPaciente);


                pacientes.add(paciente);
            }

            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pacientes;
    }
}
