package com.raul.block13mongodb.controller;

import com.raul.block13mongodb.Dto.PersonaInputDto;
import com.raul.block13mongodb.Dto.PersonaOutputDto;
import com.raul.block13mongodb.aplication.PersonDAL;
import com.raul.block13mongodb.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/persona")
public class Controlador {
    @Autowired
    private PersonDAL personDAL;

    @PostMapping
    public ResponseEntity<PersonaOutputDto> createPerson(@RequestBody PersonaInputDto persona) {
        Persona person = new Persona(persona);

        personDAL.savePerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(person.personaToPersonaOutputDto());
    }

    @GetMapping
    public ResponseEntity<List<PersonaOutputDto>> getAllPersons() {
        List<PersonaOutputDto> persons = new ArrayList<>();
        for (Persona persona:personDAL.getAllPerson()){
            persons.add(persona.personaToPersonaOutputDto());
        }
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> getPersonById(@PathVariable("id") String id) {
        Persona person = personDAL.getPersonById(id);
        if (person != null) {
            return ResponseEntity.ok(person.personaToPersonaOutputDto());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> updatePerson(@PathVariable("id") String id, @RequestBody PersonaInputDto updatedPerson) {
        Persona existingPerson = personDAL.getPersonById(id);
        if (existingPerson != null) {
            Persona updatedPersona = personDAL.updateOnePerson(new Persona(updatedPerson));
            return ResponseEntity.ok(existingPerson.personaToPersonaOutputDto());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") String id) {
        Persona existingPerson = personDAL.getPersonById(id);
        if (existingPerson != null) {
            personDAL.deletePerson(existingPerson);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
