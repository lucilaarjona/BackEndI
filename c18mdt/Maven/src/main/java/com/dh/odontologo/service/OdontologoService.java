package com.dh.odontologo.service;

import com.dh.odontologo.dao.IDao;
import com.dh.odontologo.model.Odontologo;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardar(Odontologo o){
        return odontologoIDao.guardar(o);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoIDao.buscarTodos();
    }

}
