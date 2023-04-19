package com.raul.block6simplecontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.ArrayList;

@SpringBootApplication
public class Block6SimpleControllersApplication {
	@Autowired
	private static Environment env;




	public static void main(String[] args) {

		SpringApplication.run(Block6SimpleControllersApplication.class, args);

	}



}
