package com.block5commandlinerunner.block5commandlinerunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class Block5CommandLineRunnerApplication implements CommandLineRunner{



	@Autowired
	private Clase2 claseSecundaria = new Clase2();

	@Autowired
	protected static Clase3 terceraClase = new Clase3();;



	public static void main(String[] args) {
		SpringApplication.run(Block5CommandLineRunnerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		claseSecundaria.imprimirHola();
		terceraClase.imprimirHola();

	}






}
