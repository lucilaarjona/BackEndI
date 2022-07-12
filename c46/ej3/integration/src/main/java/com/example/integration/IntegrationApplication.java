package com.example.integration;

import com.example.integration.model.Usuario;
import com.example.integration.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UsuarioRepository usuarioRepository) {
		return (args -> {
			usuarioRepository.save(new Usuario("Pilas", "pilas@digital.com"));
			usuarioRepository.save(new Usuario("Vicket", "vicket@digital.com"));
		});
	}

}
