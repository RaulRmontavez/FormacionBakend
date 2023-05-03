package com.raul.block7crudvalidation.controller;

import com.raul.block7crudvalidation.Application.PersonaService;
import com.raul.block7crudvalidation.Application.StudentService;
import com.raul.block7crudvalidation.controller.dto.PersonaInputDto;
import com.raul.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.raul.block7crudvalidation.controller.dto.StudentInputDto;
import com.raul.block7crudvalidation.controller.dto.StudentOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/student")
public class ControladorStudent {

    @Autowired
    StudentService studentService;

    //Obtener los estudiantes
    @GetMapping("id/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable int id, @RequestParam String outputType) {

        if (outputType.equals("full")){
            try {
                return ResponseEntity.ok().body(studentService.getStudentById(id));
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }

        }
        else if (outputType.equals("simple")){
            try {
                return ResponseEntity.ok().body(studentService.getStudentByIdSimple(id));
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
        }
        else{
            return ResponseEntity.badRequest().build();
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


    //Agregar una persona
    @PostMapping
    public ResponseEntity<StudentOutputDto> addStudent(@RequestBody StudentInputDto student) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student));
    }

    //Borrar una persona
   /* @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonaById(@PathVariable int id) {
        try {
            studentService.deletePersonaById(id);
            return ResponseEntity.ok().body("persona with id: "+id+" was deleted");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }*/
    //Modificar una persona
  /*  @PutMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> updatePersona(@RequestBody PersonaInputDto persona, @PathVariable int id) {
        try {
            studentService.getPersonaById(id);
            studentService.updatePersona(persona,id);
            return  ResponseEntity.ok().body(studentService.getPersonaById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
*/
}
