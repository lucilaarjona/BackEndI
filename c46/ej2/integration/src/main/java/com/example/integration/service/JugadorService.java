package com.example.integration.service;

import com.example.integration.repository.JugadorRepository;
import com.example.integration.model.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public Optional<Jugador> findByName(String name) {
       return jugadorRepository.findByName(name);
    }
}
