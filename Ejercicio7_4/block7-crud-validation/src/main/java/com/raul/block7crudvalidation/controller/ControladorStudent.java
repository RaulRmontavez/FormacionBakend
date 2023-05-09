package com.raul.block7crudvalidation.controller;

import com.raul.block7crudvalidation.Application.StudentService;
import com.raul.block7crudvalidation.controller.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    //Agregar una asignatura a un estudiante
    @PostMapping("/studentAsignatura")
    public ResponseEntity<StudentOutputDto> addAsignatura(@RequestParam int id_asignatura, @RequestParam int id_estudiante) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addAsignatura(id_asignatura,id_estudiante));
    }

    //Agregar muchas asignaturas a un estudiante
    @PostMapping("/studentAsignatura/{id_estudiante}")
    public ResponseEntity<StudentOutputDto> addAsignaturas(@PathVariable int id_estudiante,@RequestBody List<Integer> id_asignaturas) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addAsignaturas(id_asignaturas,id_estudiante));
    }

    //Agregar un estudiante
    @PostMapping
    public ResponseEntity<StudentOutputDto> addStudent(@RequestBody StudentInputDto student) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student));
    }

    //Borrar un estudiante
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
        try {
            studentService.deleteStudentById(id);
            return ResponseEntity.ok().body("Student with id: "+id+" was deleted");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }
    //Modificar un estudiante
    @PutMapping("/{id}")
    public ResponseEntity<StudentOutputDto> updateStudent(@RequestBody StudentInputDto student, @PathVariable int id) {
        try {
            studentService.getStudentById(id);
            studentService.updateStudent(student,id);
            return  ResponseEntity.ok().body(studentService.getStudentById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
