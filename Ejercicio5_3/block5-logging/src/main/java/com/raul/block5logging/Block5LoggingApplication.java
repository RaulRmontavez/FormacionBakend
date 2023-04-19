package com.raul.block5logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5LoggingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Block5LoggingApplication.class, args);
	}
	@Autowired
	Controlador controlador;

	@Override
	public void run(String... args) throws Exception {
		controlador.index();
	}
}
