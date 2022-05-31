package name.com.dh.clinica.dao.impl;

import name.com.dh.clinica.dao.IDao;
import name.com.dh.clinica.model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOH2 implements IDao<Paciente> {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_aviones";
    private final static String DB_USER = "";
    private final static String DB_PASSWORD = "";
    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO PACIENTE VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setLong(1, paciente.getId());
            preparedStatement.setString(2, paciente.getNombre());
            preparedStatement.setString(3, paciente.getApellido());
            preparedStatement.setString(4, paciente.getDni());
            preparedStatement.setString(5, paciente.getFechaingreso());
            preparedStatement.setString(6,paciente.getDomicilio());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLExceptprivate final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_aviones";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";
    @Override
    public Avion guardar(Avion avion) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO aviones VALUES (?,?,?,?,?)");
            preparedStatement.setLong(1, avion.getId());
            preparedStatement.setString(2, avion.getMarca());
            preparedStatement.setString(3, avion.getModelo());
            preparedStatement.setString(4, avion.getMatricula());
            preparedStatement.setString(5, avion.getFechaEntradaServicio());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return avion;

    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM aviones where id=?");
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
    public Avion buscar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Avion avion = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT * FROM aviones where id=?");
            preparedStatement.setLong(1, id);

            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                Long idAvion = result.getLong("id");
                String marcaAvion = result.getString("marca");
                String modeloAvion = result.getString("modelo");
                String matriculaAvion = result.getString("matricula");
                String fechaEntradaServicioAvion = result.getString("fechaEntradaServicio");
                avion = new Avion();
                avion.setId(idAvion);
                avion.setMarca(marcaAvion);
                avion.setModelo(modeloAvion);
                avion.setMatricula(matriculaAvion);
                avion.setFechaEntradaServicio(fechaEntradaServicioAvion);
            }

            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return avion;
    }

    @Override
    public List<Paciente> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Paciente> aviones = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT * FROM aviones");

            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                Long idAvion = result.getLong("id");
                String marcaAvion = result.getString("marca");
                String modeloAvion = result.getString("modelo");
                String matriculaAvion = result.getString("matricula");
                String fechaEntradaServicioAvion = result.getString("fechaEntradaServicio");
                Paciente paciente1 = new Paciente();
                avion.setId(idAvion);
                avion.setMarca(marcaAvion);
                avion.setModelo(modeloAvion);
                avion.setMatricula(matriculaAvion);
                avion.setFechaEntradaServicio(fechaEntradaServicioAvion);

                aviones.add(avion);
            }

            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return paciente;
    }ion e) {
            throw new RuntimeException(e);
        }

        return paciente;

    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM aviones where id=?");
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
    public Avion buscar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Avion avion = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT * FROM aviones where id=?");
            preparedStatement.setLong(1, id);

            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                Long idAvion = result.getLong("id");
                String marcaAvion = result.getString("marca");
                String modeloAvion = result.getString("modelo");
                String matriculaAvion = result.getString("matricula");
                String fechaEntradaServicioAvion = result.getString("fechaEntradaServicio");
                avion = new Avion();
                avion.setId(idAvion);
                avion.setMarca(marcaAvion);
                avion.setModelo(modeloAvion);
                avion.setMatricula(matriculaAvion);
                avion.setFechaEntradaServicio(fechaEntradaServicioAvion);
            }

            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return avion;
    }

    @Override
    public List<Avion> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Avion> aviones = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT * FROM aviones");

            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                Long idAvion = result.getLong("id");
                String marcaAvion = result.getString("marca");
                String modeloAvion = result.getString("modelo");
                String matriculaAvion = result.getString("matricula");
                String fechaEntradaServicioAvion = result.getString("fechaEntradaServicio");
                Avion avion = new Avion();
                avion.setId(idAvion);
                avion.setMarca(marcaAvion);
                avion.setModelo(modeloAvion);
                avion.setMatricula(matriculaAvion);
                avion.setFechaEntradaServicio(fechaEntradaServicioAvion);

                aviones.add(avion);
            }

            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aviones;
    }
}
