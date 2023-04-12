package com.raul.block5properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service
public class Block5PropertiesApplication implements CommandLineRunner {
    @Value("${greeting}")
    private String greeting;
    @Value("${my.number}")
    private int minumero;



    public static void main(String[] args) {
        SpringApplication.run(Block5PropertiesApplication.class, args);


    }


    private String property = System.getenv().get("new.property");


    @Override
    public void run(String... args) throws Exception {
        System.out.println("El valor de greeting es: " + greeting);

        System.out.println("El valor de minumero es: " + minumero);
        System.out.println("El valor de new.property es: " + property);

    }


}
