package com.block5commandlinerunner.block5commandlinerunner;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Clase3 implements CommandLineRunner{

    @PostConstruct
    public void imprimirHola() {
        System.out.println("Hola desde clase tercera");
    }

    @Override
    public void run(String... args) throws Exception {
        for (String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
    }

}
