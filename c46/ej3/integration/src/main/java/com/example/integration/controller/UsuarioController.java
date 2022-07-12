package com.example.integration.controller;

import com.example.integration.model.Usuario;
import com.example.integration.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUsuarioByEmail(@PathVariable("email") String email) {
        Optional<Usuario> usuario = usuarioService.findByEmail(email);
        if(!usuario.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity(usuario, HttpStatus.OK);
    }
}
