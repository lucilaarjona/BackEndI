package com.dh.service;

import com.dh.dao.ConfiguracionJDBC;
import com.dh.model.Domicilio;
import com.dh.model.Paciente;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicePacientesTest {

    private ServicePacientes servicePacientes = new ServicePacientes();

    public ServicePacientesTest() throws Exception {}

    @AfterEach
    public void reset() throws Exception {
        servicePacientes = new ServicePacientes(new ConfiguracionJDBC("org.h2.Driver", "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql';", "sa", ""));
    }

    @BeforeAll
    public static void init() {
        PropertyConfigurator.configure("src/test/resources/log4j.properties");
    }

    @Test
    public void test01DarDeAltaPacienteConDomicilioID() {
        Paciente paciente = new Paciente("Pepe", "Pepardo", 123456789, Date.valueOf("2021-08-26"), new Domicilio(1));
        String respuestaEsperada = "El paciente " + paciente + " fue dado de alta con éxito";

        String respuesta = servicePacientes.darDeAlta("Pepe", "Pepardo", 123456789, Date.valueOf("2021-08-26"), 1);

        assertEquals(respuestaEsperada, respuesta);
    }

    @Test
    public void test02DarDeAltaPacienteConTodosLosDatos() {
        Domicilio domicilio = new Domicilio("Calle Falsa", 123, "Springfield", "Springfield");
        Paciente paciente = new Paciente("Pepe", "Pepardo", 123456789, Date.valueOf("2021-08-26"), domicilio);
        String respuestaEsperada = "El paciente " + paciente + " fue dado de alta con éxito";

        String respuesta = servicePacientes.darDeAlta("Pepe", "Pepardo", 123456789, Date.valueOf("2021-08-26"), "Calle Falsa", 123, "Springfield", "Springfield");

        assertEquals(respuestaEsperada, respuesta);
    }

    @Test
    public void test03NoSePuedeDarDeAltaPacienteSiAlgunCampoEsNull() {
        String respuestaEsperada = "No se pudo dar de alta el paciente";

        String respuesta = servicePacientes.darDeAlta(null, "Pepardo", 123456789, Date.valueOf("2021-08-26"), null);

        assertEquals(respuestaEsperada, respuesta);
    }

    @Test
    public void test04NoSePuedeActualizarDatosDeUnPacienteInexistenteEnBD() {
        String respuestaEsperada = "Paciente con ID: 13 no encontrado";

        String respuesta = servicePacientes.actualizar(13, "Pepe", "Pepardo", 123456789, Date.valueOf("2021-08-26"), 1);

        assertEquals(respuestaEsperada, respuesta);
    }}
