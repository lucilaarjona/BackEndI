package com.dh.dao.impl;

import com.dh.dao.ConfiguracionJDBC;
import com.dh.model.Domicilio;
import com.dh.model.Paciente;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteDaoH2Test {

    private PacienteDaoH2 pacienteDaoH2 = new PacienteDaoH2(new ConfiguracionJDBC());

    public PacienteDaoH2Test() throws Exception {}

//    @BeforeAll
//    public static void init() {
//        PropertyConfigurator.configure("target/pom.xml");
//    }

    @Test
    public void test01NoSePuedeInstanciarSinConfiguracion() throws Exception {
        assertThrows(Exception.class,
                () -> new PacienteDaoH2(null));
    }

    @Test
    public void test02InsertarPaciente() throws Exception {
        Paciente pacienteOriginal = new Paciente("Pepa", "Peparda", 123456789, Date.valueOf("2021-08-18"), new Domicilio(1));
        Paciente pacienteInsertado = pacienteDaoH2.insertarNuevo(pacienteOriginal);
        assertNotNull(pacienteInsertado.getPacienteID());
    }

    @Test
    public void test03NoSePuedeInsertarPacienteNull() throws Exception {
        assertThrows(Exception.class,
                () -> pacienteDaoH2.insertarNuevo(null));
    }

    @Test
    public void test04BorrarTodos() throws Exception {
        pacienteDaoH2.insertarNuevo(new Paciente("Pepo", "Pepardo", 123456789, Date.valueOf("2021-08-18"), new Domicilio(1)));
        pacienteDaoH2.insertarNuevo(new Paciente("Pepito", "Peposo", 987654321, Date.valueOf("2021-08-18"), new Domicilio(1)));
        pacienteDaoH2.borrarTodos();
        assertEquals(0, pacienteDaoH2.consultarTodos().size());
    }

    @Test
    public void test05ConsultarPorID() throws Exception {
        Paciente pacienteExistente = pacienteDaoH2.insertarNuevo(new Paciente("Pepa", "Peparda", 123456789, Date.valueOf("2021-08-18"), new Domicilio(1)));
        Paciente pacienteConsultado = pacienteDaoH2.consultarPorId(1);
        assertEquals(pacienteExistente, pacienteConsultado);
    }
}
