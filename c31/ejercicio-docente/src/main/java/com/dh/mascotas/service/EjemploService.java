package com.dh.mascotas.service;

import com.dh.mascotas.persistence.entities.Usuario;
import com.dh.mascotas.persistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjemploService {

    @Autowired
    UsuarioRepository repository;

    public String save(Usuario m){
        if(repository.save(m) != null){
            return "OK";
        }else{
            return null;
        }
    }

    public List<Usuario> obtenerTodos(){
        return repository.findAll();
    }

}
