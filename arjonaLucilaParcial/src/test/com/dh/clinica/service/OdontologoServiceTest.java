package test.com.dh.clinica.service;

import main.com.dh.clinica.model.Odontologo;
import main.com.dh.clinica.service.OdontologoService;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)
public class OdontologoServiceTest {
    private static OdontologoService odontologoService = new OdontologoService();

    @BeforeClass
    public static void cargarDataSet() {
        Odontologo o = odontologoService.guardar(new Odontologo("789456", "Juan", "Perez"));
        Odontologo o1 = odontologoService.guardar(new Odontologo("789451", "lucas", "Lopez"));

    }

    @Test
    public void agregarYBuscarOdontologoTest() {

        Odontologo o = odontologoService.guardar(new Odontologo("879846", "Tomas", "Corteggiano"));

        Assert.assertNotNull(odontologoService.buscar(o.getId()));

    }
    @Test
    public void traerTodos() {
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        Assert.assertTrue(!odontologos.isEmpty());
        Assert.assertTrue(odontologos.size() == 2);
        System.out.println(odontologos);
    }
}
