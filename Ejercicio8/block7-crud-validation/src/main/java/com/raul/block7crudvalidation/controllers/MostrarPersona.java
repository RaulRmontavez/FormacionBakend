package com.raul.block7crudvalidation.controllers;

import com.raul.block7crudvalidation.controllers.dto.PersonaOutputDto;
import com.raul.block7crudvalidation.Application.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class MostrarPersona {
    @Autowired
    PersonaServiceImpl personaServiceimpl ;
    @GetMapping("id/{id}")
    public ResponseEntity<PersonaOutputDto> getPersonaById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(personaServiceimpl.getPersonaById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("name/{name}")
    public List<PersonaOutputDto> getPersonaByNombre(@PathVariable String name) {

        return personaServiceimpl.getPersonaByName(name);
    }

    @GetMapping("all")
    public List<PersonaOutputDto> getPersonaAll() {

        return personaServiceimpl.getPersonaAll();
    }

}
