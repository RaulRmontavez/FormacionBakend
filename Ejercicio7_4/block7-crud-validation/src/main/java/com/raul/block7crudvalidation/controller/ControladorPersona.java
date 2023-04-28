package com.raul.block7crudvalidation.controller;

import com.raul.block7crudvalidation.Application.PersonaService;
import com.raul.block7crudvalidation.controller.dto.PersonaInputDto;
import com.raul.block7crudvalidation.controller.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/persona")
public class ControladorPersona {

    @Autowired
    PersonaService personaService;

    //Obtener las personas
    @GetMapping("id/{id}")
    public ResponseEntity<PersonaOutputDto> getPersonaById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(personaService.getPersonaById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("name/{name}")
    public List<PersonaOutputDto> getPersonaByNombre(@PathVariable String name) {

        return personaService.getPersonaByName(name);
    }

    @GetMapping("all")
    public Iterable<PersonaOutputDto> getAllPersonas(@RequestParam(defaultValue = "0",required = false) int pageNumber,
        @RequestParam(defaultValue = "25",required = false) int pageSize){

        return personaService.getAllPersonas(pageNumber,pageSize);
        }


    //Agregar una persona
    @PostMapping
    public ResponseEntity<PersonaOutputDto> addPersona(@RequestBody PersonaInputDto persona) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.addPersona(persona));
    }

    //Borrar una persona
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonaById(@PathVariable int id) {
        try {
            personaService.deletePersonaById(id);
            return ResponseEntity.ok().body("persona with id: "+id+" was deleted");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }
    //Modificar una persona
    @PutMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> updatePersona(@RequestBody PersonaInputDto persona, @PathVariable int id) {
        try {
            personaService.getPersonaById(id);
            personaService.updatePersona(persona,id);
            return  ResponseEntity.ok().body(personaService.getPersonaById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
