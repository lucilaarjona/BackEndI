package com.dh;

import com.dh.dao.ConfiguracionJDBC;
import com.dh.service.ServiceOdontologos;
import com.dh.service.ServicePacientes;
import org.apache.log4j.Logger;

import java.sql.Date;

public class ClinicaOdontologica {

    private ServiceOdontologos serviceOdontologos;
    private ServicePacientes servicePacientes;
    private static final Logger logger = Logger.getLogger(ClinicaOdontologica.class);

    public ClinicaOdontologica() {
        try {
            this.serviceOdontologos = new ServiceOdontologos(new ConfiguracionJDBC());
            this.servicePacientes = new ServicePacientes(new ConfiguracionJDBC());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public ClinicaOdontologica(ConfiguracionJDBC configuracionJDBC) {
        try {
            this.serviceOdontologos = new ServiceOdontologos(configuracionJDBC);
            this.servicePacientes = new ServicePacientes(configuracionJDBC);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public ClinicaOdontologica(ServiceOdontologos serviceOdontologos, ServicePacientes servicePacientes) {
        this.serviceOdontologos = serviceOdontologos;
        this.servicePacientes = servicePacientes;
    }

    public String darDeAltaPaciente(String nombre, String apellido, Integer dni, Date fecha, String calle, Integer numero, String localidad, String provincia) {
        return servicePacientes.darDeAlta(nombre, apellido, dni, fecha, calle, numero, localidad, provincia);
    }

    public String darDeAltaOdontologo(String nombre, String apellido, String numeroMatricula) {
        return serviceOdontologos.darDeAlta(nombre, apellido, numeroMatricula);
    }

    public String actualizarPaciente(Integer id, String nombre, String apellido, Integer dni, Date fecha, Integer domicilioId) {
        return servicePacientes.actualizar(id, nombre, apellido, dni, fecha, domicilioId);
    }

    public String actualizarOdontologo(Integer id, String nombre, String apellido, String numeroMatricula) {
        return serviceOdontologos.actualizar(id, nombre, apellido, numeroMatricula);
    }

    public String buscarPacientePorId(Integer id) {
        return servicePacientes.buscarPacientePorId(id);
    }

    public String buscarOdontologoPorId(Integer id) {
        return serviceOdontologos.buscarPorId(id);
    }

    public String consultarTodos() {
        return servicePacientes.consultarTodos() + "\n" + serviceOdontologos.consultarTodos();
    }
}
