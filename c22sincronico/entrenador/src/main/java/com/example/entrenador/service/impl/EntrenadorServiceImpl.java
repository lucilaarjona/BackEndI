package com.example.entrenador.service.impl;

import com.example.entrenador.model.Entrenador;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class EntrenadorServiceImpl implements EntrenadorService {
    @Override
    public List<Entrenador> listaEntrenador() {
        return Arrays.asList(new Entrenador("Juan"), new Entrenador("Martin"));
    }
}
