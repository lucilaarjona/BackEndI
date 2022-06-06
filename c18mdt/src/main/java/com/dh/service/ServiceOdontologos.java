package com.dh.service;

import com.dh.dao.ConfiguracionJDBC;
import com.dh.dao.IDao;
import com.dh.dao.impl.OdontologoDaoH2;
import com.dh.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class ServiceOdontologos {

    private static final Logger logger = Logger.getLogger(ServiceOdontologos.class);
    private IDao<Odontologo> odontologoIDao = new OdontologoDaoH2(new ConfiguracionJDBC());

    public ServiceOdontologos() throws Exception {
        try {
            odontologoIDao = new OdontologoDaoH2(new ConfiguracionJDBC());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public ServiceOdontologos(ConfiguracionJDBC configuracionJDBC) throws Exception {
        try {
            odontologoIDao = new OdontologoDaoH2(configuracionJDBC);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public String buscarPorId(Integer id) {
        String respuesta = "Odontologo con ID: " + id + " no encontrado";
        try {
            Odontologo odontologo = odontologoIDao.consultarPorId(id);
            if (odontologo != null) {
                respuesta = "El odontologo con ID: " + id + " es " + odontologo;
                logger.info(respuesta);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    public String darDeAlta(String nombre, String apellido, String numeroMatricula) {
        String respuesta = "No se pudo dar de alta el odontologo";
        try {
            Odontologo odontologo = new Odontologo(nombre, apellido, numeroMatricula);
            Odontologo insertado = odontologoIDao.insertarNuevo(odontologo);
            respuesta = "El odontologo " + insertado + " fue dado de alta con éxito";
            logger.info(respuesta);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    public String actualizar(Integer odontologoID, String nombre, String apellido, String numeroMatricula) {
        String respuesta = "Odontologo con ID: " + odontologoID + " no encontrado";
        try {
            Odontologo odontologo = odontologoIDao.consultarPorId(odontologoID);
            odontologo.setNombre(nombre);
            odontologo.setApellido(apellido);
            odontologo.setMatricula(numeroMatricula);
            if (odontologo.getNombre() != null && odontologo.getApellido() != null && odontologo.getMatricula() != null && odontologo.getId() != null) {
                odontologoIDao.actualizar(odontologo);
                respuesta = "Los nuevos datos son:\n" + odontologo;
                logger.info(respuesta);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    public String consultarTodos() {
        String respuesta = "No hay odontologos";
        try {
            List<Odontologo> odontologos = odontologoIDao.consultarTodos();
            if (odontologos.size() > 0) {
                respuesta = "Los odontologos son:\n";
                for (Odontologo o : odontologos) {
                    respuesta += "\n" + o;
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    public void borrarTodos() {
        try {
            odontologoIDao.borrarTodos();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}
