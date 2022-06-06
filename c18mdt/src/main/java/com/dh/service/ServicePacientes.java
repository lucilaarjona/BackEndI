package com.dh.service;

import com.dh.dao.ConfiguracionJDBC;
import com.dh.dao.IDao;
import com.dh.dao.impl.DomicilioDaoH2;
import com.dh.dao.impl.PacienteDaoH2;
import com.dh.model.Domicilio;
import com.dh.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class ServicePacientes {

    private static final Logger logger = Logger.getLogger(ServicePacientes.class);
    private final IDao<Paciente> pacienteDaoH2;
    private final IDao<Domicilio> domicilioDaoH2;

    public ServicePacientes() throws Exception {
        pacienteDaoH2 = new PacienteDaoH2(new ConfiguracionJDBC());
        domicilioDaoH2 = new DomicilioDaoH2(new ConfiguracionJDBC());
    }

    public ServicePacientes(ConfiguracionJDBC configuracionJDBC) throws Exception {
        this.pacienteDaoH2 = new PacienteDaoH2(configuracionJDBC);
        this.domicilioDaoH2 = new DomicilioDaoH2(configuracionJDBC);
    }

    public String buscarPacientePorId(Integer id) {
        String respuesta = "Paciente con ID: " + id + " no encontrado";
        try {
            Paciente paciente = pacienteDaoH2.consultarPorId(id);
            if (paciente != null) {
                Domicilio domicilio = domicilioDaoH2.consultarPorId(paciente.getDomicilio().getDomicilioID());
                paciente.setDomicilio(domicilio);
                respuesta = "El paciente con ID: " + id + " es " + paciente;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    public String darDeAlta(String nombre, String apellido, Integer dni, Date fecha, Integer domicilioID) {
        String respuesta = "No se pudo dar de alta el paciente";
        Paciente paciente = new Paciente(nombre, apellido, dni, fecha, new Domicilio(domicilioID));
        try {
            if (domicilioDaoH2.consultarPorId(domicilioID) != null) {
                pacienteDaoH2.insertarNuevo(paciente);
                respuesta = "El paciente " + paciente + " fue dado de alta con éxito";
            } else {
                respuesta += ", el domicilio no es válido.";
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    public String darDeAlta(String nombre, String apellido, Integer dni, Date fecha, String calle, Integer numero, String localidad, String provincia) {
        String respuesta = "No se pudo dar de alta el paciente";
        Domicilio domicilio = new Domicilio(calle, numero, localidad, provincia);
        try {
            Integer domicilioID = domicilioDaoH2.insertarNuevo(domicilio).getDomicilioID();
            domicilio.setDomicilioID(domicilioID);
            Paciente paciente = new Paciente(nombre, apellido, dni, fecha, domicilio);
            pacienteDaoH2.insertarNuevo(paciente);
            respuesta = "El paciente " + paciente + " fue dado de alta con éxito";
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    public String actualizar(Integer pacienteID, String nombre, String apellido, Integer dni, Date fecha, Integer domicilioID) {
        String respuesta = "Paciente con ID: " + pacienteID + " no encontrado";
        try {
            Paciente paciente = pacienteDaoH2.consultarPorId(pacienteID);
            paciente.setNombre(nombre);
            paciente.setApellido(apellido);
            paciente.setDni(dni);
            paciente.setFechaIngreso(fecha);
            Domicilio domicilio = domicilioDaoH2.consultarPorId(domicilioID);
            paciente.setDomicilio(domicilio);
            if (paciente.getNombre() != null && paciente.getApellido() != null && paciente.getDni() != null && paciente.getFechaIngreso() != null) {
                respuesta = "Los nuevos datos son:\n" + paciente;
                pacienteDaoH2.actualizar(paciente);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    public String consultarTodos() {
        String respuesta = "No hay pacientes";
        try {
            List<Paciente> pacientes = pacienteDaoH2.consultarTodos();
            if (pacientes.size() > 0) {
                respuesta = "Los pacientes son:\n";
                for (Paciente p : pacientes) {
                    respuesta += "\n" + p;
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }
}
