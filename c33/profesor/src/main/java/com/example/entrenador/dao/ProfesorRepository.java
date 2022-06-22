package com.example.entrenador.dao;

import com.example.entrenador.modelo.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Alumno, Long> {
}
