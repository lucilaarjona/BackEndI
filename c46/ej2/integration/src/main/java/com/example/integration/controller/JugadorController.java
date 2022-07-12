package com.example.integration.controller;

import com.example.integration.model.Jugador;
import com.example.integration.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;


    @GetMapping("/jugador/{name}")
    public ResponseEntity<Jugador> getCustomerById(@PathVariable("name") String name) {
        Optional<Jugador> customer = jugadorService.findByName(name);
        if(!customer.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity(customer, HttpStatus.OK);
    }
}
