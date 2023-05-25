package com.raul.block7crudvalidation.controller;

import com.raul.block7crudvalidation.Application.PersonaService;
import com.raul.block7crudvalidation.Application.ProfesorService;
import com.raul.block7crudvalidation.controller.dto.PersonaInputDto;
import com.raul.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.raul.block7crudvalidation.controller.dto.ProfesorOutputDto;
import com.raul.block7crudvalidation.repository.PersonaRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/persona")
public class ControladorPersona {

    @Autowired
    PersonaService personaService;

    @Autowired
    ProfesorService profesorService;

    @Autowired
    PersonaRepository personaRepository;
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

    @GetMapping("/customquery")
    public Iterable<PersonaOutputDto> findPersonaByData(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String usuario,
            @RequestParam(required = false) String created_date,
            @RequestParam(required = false,defaultValue = "asc") String ord,
            @RequestParam (required = false,defaultValue = "none") String order,
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "10", required = false) int pageSize)
             {

        HashMap<String, Object> data = new HashMap<>();

        if(name != null) data.put("name",name);
        if(surname != null) data.put ("surname", surname);
        if(usuario != null) data.put ("usuario", usuario);
        if(created_date != null) data.put ("created_date", created_date);
        if (!ord.equals("asc") && !ord.equals("desc")) ord = "asc";
        if(!order.equals("name") && !order.equals("usuario")) order = "none";

        return personaRepository.getCustomQuery(data,ord,order,pageNumber, pageSize);
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
