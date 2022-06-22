package com.example.entrenador.dao;

import com.example.entrenador.modelo.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Profesor, Long> {
}
