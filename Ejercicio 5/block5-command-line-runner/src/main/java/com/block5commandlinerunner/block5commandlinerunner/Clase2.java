package com.block5commandlinerunner.block5commandlinerunner;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Clase2 implements CommandLineRunner {

    @PostConstruct
    public void imprimirHola() {
        System.out.println("Hola desde clase secundaria");
    }

    @Override
    public void run(String... args) throws Exception {

    }
}


