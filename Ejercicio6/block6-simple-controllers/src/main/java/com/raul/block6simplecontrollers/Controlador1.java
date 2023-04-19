package com.raul.block6simplecontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class Controlador1 {


    ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();

    protected Persona p;



    @GetMapping("/user/{nombre}")
    public String saludo(@PathVariable String nombre) {
        return "Hola soy " + nombre;
    }


    @PostMapping("/useradd")
    public Persona userJson(@RequestBody Persona persona) {
        persona.setEdad(persona.getEdad() + 1);
        return persona;
    }

    @GetMapping("/controlador1/addPersona")
    public void crearPersona(@RequestHeader String nombre, @RequestHeader String poblacion, @RequestHeader int edad) {
        p.setNombre(nombre);
        p.setPoblacion(poblacion);
        p.setEdad(edad);
        System.out.println(p);
    }

    @PostMapping("/controlador1/addCiudad")
    public void crearCiudad(@RequestBody Ciudad ciudad) {
        ciudades.add(ciudad);
        System.out.println(ciudad);

    }




    public Persona pasarPersona() {
        return p;
    }

    public ArrayList<Ciudad> pasarCiudades() {
        return ciudades;
    }


}
