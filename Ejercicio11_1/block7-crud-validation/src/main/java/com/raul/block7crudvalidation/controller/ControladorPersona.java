package com.raul.block7crudvalidation.controller;

import com.raul.block7crudvalidation.Application.PersonaService;
import com.raul.block7crudvalidation.Application.ProfesorService;
import com.raul.block7crudvalidation.controller.dto.PersonaInputDto;
import com.raul.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.raul.block7crudvalidation.controller.dto.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;
@RestController
@CrossOrigin("*")
//@RequestMapping("/persona")
public class ControladorPersona {

    @Autowired
    PersonaService personaService;

    @Autowired
    ProfesorService profesorService;
    @Autowired

    ProfesorClient profesorClient;

  //  private final RestTemplate restTemplate;

  /*  public ControladorPersona(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }*/

    //Obtener las personas
    @GetMapping("id/{id}")
    public ResponseEntity<PersonaOutputDto> getPersonaById(@PathVariable int id) {

        try {
            return ResponseEntity.ok().body(personaService.getPersonaById(id));

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

   /* @GetMapping("/profesor/{id}")
    public ResponseEntity<ProfesorOutputDto> getProfesor(@PathVariable int id) {
        try {
            String url = "http://localhost:8081/profesor/id/{id}";
            ProfesorOutputDto profesorOutputDto = restTemplate.getForObject(url, Profesor.class, id).profesorOutputDto();
            return ResponseEntity.ok().body(profesorOutputDto);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }*/

    @GetMapping("/profesor/{id}")
    public ProfesorOutputDto getProfesor(@PathVariable int id) {
        ProfesorOutputDto profesor = profesorClient.getProfesor(id);
        return profesor;
    }


    @GetMapping("name/{name}")
    public List<PersonaOutputDto> getPersonaByNombre(@PathVariable String name) {

        return personaService.getPersonaByName(name);
    }

    @GetMapping("getall")
    public Iterable<PersonaOutputDto> getAllPersonas(@RequestParam(defaultValue = "0",required = false) int pageNumber,
        @RequestParam(defaultValue = "25",required = false) int pageSize){

        return personaService.getAllPersonas(pageNumber,pageSize);
        }


    //Agregar una persona
    /*@PostMapping
    public ResponseEntity<PersonaOutputDto> addPersona(@RequestBody PersonaInputDto persona) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.addPersona(persona));
    }*/

    //Agregar una persona

    @PostMapping("addperson")
    public ResponseEntity<PersonaOutputDto> addperson(@RequestBody PersonaInputDto persona) throws Exception {
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
