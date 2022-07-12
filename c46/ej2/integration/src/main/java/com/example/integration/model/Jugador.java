package com.example.integration.model;

import javax.persistence.*;

@Entity
public class Jugador {

    @Id
    @SequenceGenerator(name = "jugador_sequence", sequenceName = "jugador_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jugador_sequence")
    private Long id;
    private String name;
    private int edad;

    public Jugador() {
    }

    public Jugador(String name, int edad) {
        this.name = name;
        this.edad = edad;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
