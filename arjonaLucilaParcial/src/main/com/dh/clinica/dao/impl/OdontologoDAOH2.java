package main.com.dh.clinica.dao.impl;
import main.com.dh.clinica.dao.IDao;
import main.com.dh.clinica.model.Odontologo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {
private final static String DB_JDBC_DRIVER="org.h2.Driver";
private final static String DB_URL="jdbc:h2:~/odontologos";
private final static String DB_USER="";
private final static String DB_PASSWORD="";
@Override

public Odontologo guardar(Odontologo odontologo){
        Connection connection=null;
        PreparedStatement preparedStatement=null;

        try{
        Class.forName(DB_JDBC_DRIVER);
        connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

        preparedStatement=connection.prepareStatement("INSERT INTO odontologos VALUES (?,?,?,?)");
        preparedStatement.setLong(1,odontologo.getId());
        preparedStatement.setString(2,odontologo.getNumeroMatricula());
        preparedStatement.setString(3,odontologo.getNombre());
        preparedStatement.setString(4,odontologo.getApellido());

        preparedStatement.executeUpdate();
        preparedStatement.close();

        }catch(ClassNotFoundException e){
        e.printStackTrace();
        }catch(SQLException e){
        throw new RuntimeException(e);
        }

        return odontologo;
        }

@Override
public Odontologo buscar(long id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Odontologo odontologo=null;

        try{
        Class.forName(DB_JDBC_DRIVER);
        connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

        preparedStatement=connection.prepareStatement("SELECT * FROM odontologos where id=?");
        preparedStatement.setLong(1,id);

        ResultSet result=preparedStatement.executeQuery();
        while(result.next()){
        Long idOdontologos=result.getLong("id");
        String numeroMatricula=result.getString("numeroMatricula");
        String nombre=result.getString("nombre");
        String apellido=result.getString("apellido");


        odontologo=new Odontologo(idOdontologos, numeroMatricula, nombre,apellido);

        }

        preparedStatement.close();

        }catch(ClassNotFoundException e){
        e.printStackTrace();
        }catch(SQLException e){
        throw new RuntimeException(e);
        }
        return odontologo;
        }

@Override
public List<Odontologo> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try {
                Class.forName(DB_JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

                preparedStatement = connection.prepareStatement("SELECT * FROM odontologos");

                ResultSet result = preparedStatement.executeQuery();

                while (result.next()) {
                        Long idOdontologos = result.getLong("id");
                        String numeroMatricula = result.getString("numeroMatricula");
                        String nombre = result.getString("nombre");
                        String apellido = result.getString("apellido");
                        Odontologo odontologo = new Odontologo(idOdontologos, numeroMatricula, nombre, apellido);
                        odontologos.add(odontologo);
                }

                preparedStatement.close();

        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        } catch (SQLException e) {
                throw new RuntimeException(e);
        }
        return odontologos;
}
}

