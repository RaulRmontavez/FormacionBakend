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

    //Borrar una asignatura
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAsginaturaById(@PathVariable int id) {
        try {
            alumnosEstudiosService.deleteAlumnos_EstudiosById(id);
            return ResponseEntity.ok().body("asignatura with id: "+id+" was deleted");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }
    //Modificar una asignatura
    @PutMapping("/{id}")
    public ResponseEntity<Alumnos_EstudiosOutputDto> updateAsignatura(@RequestBody Alumnos_EstudiosInputDto asignatura, @PathVariable int id) {
        try {
            alumnosEstudiosService.getAlumnos_EstudiosById(id);
            alumnosEstudiosService.updateAlumnos_Estudios(asignatura,id);
            return  ResponseEntity.ok().body(alumnosEstudiosService.getAlumnos_EstudiosById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
