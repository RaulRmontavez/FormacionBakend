package com.raul.block6simplecontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class Controlador1 {
    @Autowired
    protected Persona p;

    @GetMapping("/user/{nombre}")
    public String saludo(@PathVariable String nombre){
        return "Hola soy " + nombre;
    }




    @PostMapping("/useradd")
    public Persona userJson(@RequestBody Persona persona){
        persona.setEdad(persona.getEdad()+1);
            return persona;
        }

    @GetMapping("/controlador1/addPersona")
    public void crearPersona(@RequestHeader String nombre,@RequestHeader String poblacion,@RequestHeader int edad){
        p.setNombre(nombre);
        p.setPoblacion(poblacion);
        p.setEdad(edad);
        System.out.println(p);
    }

    public Persona pasarPersona(){
        return p;
    }


}
