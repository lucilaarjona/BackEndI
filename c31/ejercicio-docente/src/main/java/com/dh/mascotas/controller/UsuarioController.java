package com.dh.mascotas.controller;


import com.dh.mascotas.persistence.entities.Usuario;
import com.dh.mascotas.service.EjemploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class UsuarioController {

    @Autowired
    EjemploService service;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody Usuario m){
        ResponseEntity<String> respuesta = null;

        if(service.save(m) != null){
            respuesta = ResponseEntity.ok("El usuario fue registrado con éxito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Usuario>> consultarTodos(){
        return ResponseEntity.ok(service.obtenerTodos());
    }
}
