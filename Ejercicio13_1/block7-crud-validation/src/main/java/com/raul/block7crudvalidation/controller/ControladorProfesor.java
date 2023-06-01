package com.raul.block7crudvalidation.controller;

import com.raul.block7crudvalidation.Application.ProfesorService;
import com.raul.block7crudvalidation.Application.StudentService;
import com.raul.block7crudvalidation.controller.dto.ProfesorInputDto;
import com.raul.block7crudvalidation.controller.dto.ProfesorOutputDto;
import com.raul.block7crudvalidation.controller.dto.StudentInputDto;
import com.raul.block7crudvalidation.controller.dto.StudentOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profesor")
public class ControladorProfesor {

    @Autowired
    ProfesorService profesorService;

    //Obtener los profesores
    @GetMapping("id/{id}")
    public ResponseEntity<Object> getProfesorById(@PathVariable int id) {

            try {
                return ResponseEntity.ok().body(profesorService.getProfesorById(id));
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }

    }


    @GetMapping("id/student/{id}")
    public ResponseEntity<Object> getStudentsForProfe(@PathVariable int id) {

        try {
            return ResponseEntity.ok().body(profesorService.getStudentByIdProfe(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }


   /* @GetMapping("name/{name}")
    public List<PersonaOutputDto> getPersonaByNombre(@PathVariable String name) {

        return studentService.getPersonaByName(name);
    }
*/
   /* @GetMapping("all")
    public Iterable<PersonaOutputDto> getAllPersonas(@RequestParam(defaultValue = "0",required = false) int pageNumber,
        @RequestParam(defaultValue = "25",required = false) int pageSize){

        return studentService.getAllPersonas(pageNumber,pageSize);
        }*/


    //Agregar un profesor
    @PostMapping
    public ResponseEntity<ProfesorOutputDto> addProfesor(@RequestBody ProfesorInputDto profesor) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(profesorService.addProfesor(profesor));
    }

    //Borrar un profesor
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfesorById(@PathVariable int id) {
        try {
            profesorService.deleteProfesorById(id);
            return ResponseEntity.ok().body("Profesor with id: " + id + " was deleted");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }

    //Modificar un profesor
    @PutMapping("/{id}")
    public ResponseEntity<ProfesorOutputDto> updateProfesor(@RequestBody ProfesorInputDto profesor, @PathVariable int id) {
        try {
            profesorService.getProfesorById(id);
            profesorService.updateProfesor(profesor, id);
            return ResponseEntity.ok().body(profesorService.getProfesorById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
