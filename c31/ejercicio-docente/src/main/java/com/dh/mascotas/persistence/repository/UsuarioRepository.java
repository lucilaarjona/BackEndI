package com.dh.mascotas.persistence.repository;

import com.dh.mascotas.persistence.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
