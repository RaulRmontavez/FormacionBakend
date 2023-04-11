package com.block5commandlinerunner.block5commandlinerunner;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Clase3 implements CommandLineRunner{




    public void imprimirHola(ArrayList<String> args) {
        System.out.println("Hola desde clase tercera");

        for (String arg : args) {
            System.out.println(arg + " ");
        }
        System.out.println();
    }

    @Override
    public void run(String... args) throws Exception {

    }

}
