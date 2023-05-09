package com.raul.block7crudvalidation.controller.dto;

import com.raul.block7crudvalidation.Application.Alumnos_EstudiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asignaturas")
public class ControladorAlumnosEstudios {
    @Autowired
    Alumnos_EstudiosService alumnosEstudiosService;


    @GetMapping("id/{id}")
    public ResponseEntity<Alumnos_EstudiosOutputDto> getAsignaturaById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(alumnosEstudiosService.getAlumnos_EstudiosById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Agregar una asignatura
    @PostMapping
    public ResponseEntity<Alumnos_EstudiosOutputDto> addAsignatura(@RequestBody Alumnos_EstudiosInputDto asignatura) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnosEstudiosService.addAlumnos_Estudios(asignatura));
    }



}
