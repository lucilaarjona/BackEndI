package com.dh.service;

import com.dh.model.Odontologo;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ServiceOdontologosTest {

    private ServiceOdontologos serviceOdontologos;

    @BeforeEach
    public void reset() throws Exception {
        serviceOdontologos = new ServiceOdontologos();
    }

    @BeforeAll
    public static void init() {
        PropertyConfigurator.configure("src/test/resources/log4j.properties");
    }

    @Test
    public void test01DarDeAltaConTodosLosDatos() {
        Odontologo odontologo = new Odontologo("John", "Doe", "666666");
        String respuestaEsperada = "El odontologo " + odontologo + " fue dado de alta con éxito";

        String respuestaObtenida = serviceOdontologos.darDeAlta("John", "Doe", "666666");

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void test02NoSePuedeDarDeAltaSiAlgunCampoEsNull() {
        String respuestaEsperada = "No se pudo dar de alta el odontologo";

        String respuestaObtenida = serviceOdontologos.darDeAlta(null, "Doe", "666666");

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void test03ConsultarPorIDExistente() {
        Odontologo odontologoExistente = new Odontologo("1", "Pepe", "Pepardo", "123456");
        String respuestaEsperada = "El odontologo con ID: 1 es " + odontologoExistente;

        String respuestaObtenida = serviceOdontologos.buscarPorId(1);

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void test04ConsultarPorIDInexistente() {
        String respuestaEsperada = "Odontologo con ID: 1234 no encontrado";

        String respuestaObtenida = serviceOdontologos.buscarPorId(1234);

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void test05NoSePuedeConsultarConsultarPorIDNull() {
        String respuestaEsperada = "Odontologo con ID: null no encontrado";

        String respuestaObtenida = serviceOdontologos.buscarPorId(null);

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void test06ActualizarDatosExistente() {
        Odontologo odontologoActualizado = new Odontologo("2", "Pipo", "Piposo", "112233");
        String respuestaEsperada = "Los nuevos datos son:\n" + odontologoActualizado;

        String respuestaObtenida = serviceOdontologos.actualizar(2, "Pipo", "Piposo", "112233");

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void test07NoSePuedeActualizarDatosDeUnPacienteInexistenteEnBD() {
        String respuestaEsperada = "Odontologo con ID: 1111 no encontrado";

        String respuestaObtenida = serviceOdontologos.buscarPorId(1111);

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void test08ConsultarTodos() {
        String respuestaNoEsperada = "No hay odontologos";

        String respuestaObtenida = serviceOdontologos.consultarTodos();

        assertNotEquals(respuestaNoEsperada, respuestaObtenida);
    }

}
