package com.example.integration;

import com.example.integration.model.Jugador;
import com.example.integration.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
	public CommandLineRunner demo(JugadorRepository jugadorRepository) {
		return (args -> {
			jugadorRepository.save(new Jugador("pepe", 12));
			jugadorRepository.save(new Jugador("papa", 24));
		});
	}

}
