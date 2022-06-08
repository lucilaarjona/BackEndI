package com.dh.odontologo;

import com.dh.odontologo.dao.impl.OdontologoDaoH2;
import com.dh.odontologo.model.Odontologo;
import com.dh.odontologo.service.OdontologoService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
//import org.junit.jupiter.api.Test;

import java.util.List;


public class OdontologoServiceTest {

    private static OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    /*@BeforeClass
    public void cargarOdontologos(){
        Odontologo odontologo1 = odontologoService.guardar(new Odontologo("0000", "Carlos", "Ruiz"));
        Odontologo odontologo2 = odontologoService.guardar(new Odontologo("hk3uav", "Jose", "Camacho"));
    }*/

    @Test
    public void agregarOdontologo(){
        Odontologo odontologo3 = odontologoService.guardar(new Odontologo("123abc", "David", "Sanchez"));
        Odontologo odontologo4 = odontologoService.guardar(new Odontologo("abn123", "Pepe", "Correa"));
    }

    @Test
    public void traerTodos(){
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        Assert.assertTrue(!odontologos.isEmpty());
        Assert.assertTrue(odontologos.size() > 0);
        System.out.println(odontologos);
    }

}
