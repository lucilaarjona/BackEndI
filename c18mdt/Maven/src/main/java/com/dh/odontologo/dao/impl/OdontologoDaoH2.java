package com.dh.odontologo.dao.impl;

import com.dh.odontologo.dao.IDao;
import com.dh.odontologo.dao.configuration.ConfiguracionJDBC;
import com.dh.odontologo.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OdontologoDaoH2 implements IDao<Odontologo> {

    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);

    private ConfiguracionJDBC configuracionJDBC;

    public OdontologoDaoH2() {
        this.configuracionJDBC = new ConfiguracionJDBC();
    }


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        PreparedStatement pstmnt = null;

        try{
            pstmnt = connection.prepareStatement("INSERT INTO odontologos(numeroMatricula, nombre, apellido ) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);

            pstmnt.setString(1, odontologo.getNumeroDeMatricula());
            pstmnt.setString(2,odontologo.getNombre());
            pstmnt.setString(3, odontologo.getApellido());

            pstmnt.executeUpdate();

            ResultSet keys = pstmnt.getGeneratedKeys();

            if(keys.next()){
                odontologo.setId(keys.getInt(1));
            }
            logger.info("El odontologo ha sido agregado con exito");
            pstmnt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Hubo un error en el proceso, el odontologo no ha podido ser agregado");
        }

        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {

        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        PreparedStatement pstmnt = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try{
            pstmnt = connection.prepareStatement("SELECT * FROM odontologos");
            ResultSet result = pstmnt.executeQuery();

            while (result.next()){
                Integer idOdontologo = result.getInt("id");
                String numeroMatricula = result.getString("numeroMatricula");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");

                Odontologo odontologo = new Odontologo(idOdontologo,numeroMatricula,nombre,apellido);

                odontologos.add(odontologo);
            }
            logger.info("Se esta trayendo una lista de odontologos...");


        }catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Hubo un error al traer la lista de odontologos", throwables);
        }
        logger.info("El proceso se ha completado con exito");
        return odontologos;
    }
}
