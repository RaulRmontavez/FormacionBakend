package com.raul.block6simplecontrollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class Controlador {

    @RequestMapping("/user/{nombre}")
    public String saludo(@PathVariable String nombre){
        return "Hola soy " + nombre;
    }




    @PostMapping("/useradd")
    public Persona userJson(@RequestBody Persona persona){
        persona.setEdad(persona.getEdad()+1);
            return persona;
        }



}
