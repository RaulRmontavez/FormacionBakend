package com.block5commandlinerunner.block5commandlinerunner;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication

public class Block5CommandLineRunnerApplication implements CommandLineRunner{


	@Autowired
	private Clase1 claseInicial;

	@Autowired
	private Clase2 claseSecundaria;

	@Autowired
	private Clase3 terceraClase;

	public static void main(String[] args) {
		SpringApplication.run(Block5CommandLineRunnerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		claseInicial.imprimirHola();
		claseSecundaria.imprimirHola();
		terceraClase.imprimirHola();
	}






}
