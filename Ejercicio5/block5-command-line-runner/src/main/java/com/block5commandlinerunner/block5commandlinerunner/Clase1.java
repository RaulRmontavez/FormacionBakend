package com.block5commandlinerunner.block5commandlinerunner;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.block5commandlinerunner.block5commandlinerunner.Block5CommandLineRunnerApplication.terceraClase;

@Component
public class Clase1  {

    @PostConstruct
    public void imprimirHola() {
        String Texto = "Hola desde clase primaria";
        System.out.println(Texto);
        terceraClase.AddList(Texto);
    }


}
