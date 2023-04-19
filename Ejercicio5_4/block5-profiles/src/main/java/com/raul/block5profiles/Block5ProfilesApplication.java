package com.raul.block5profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.ConcurrentMap;

@SpringBootApplication
public class Block5ProfilesApplication {

	public static void main(String[] args) {

		SpringApplication.run(Block5ProfilesApplication.class, args);
	}


}
