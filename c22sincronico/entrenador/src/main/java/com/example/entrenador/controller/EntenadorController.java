package com.example.entrenador.controller;

import com.example.entrenador.model.Entrenador;
import com.example.entrenador.service.impl.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("entrenador")
public class EntenadorController {

    private final EntrenadorService entrenadorService;
    @Autowired
    public EntenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }
    @GetMapping("entrenador")
    public List<Entrenador> getEntrenador(){
        return entrenadorService.listaEntrenador();
    }

}
