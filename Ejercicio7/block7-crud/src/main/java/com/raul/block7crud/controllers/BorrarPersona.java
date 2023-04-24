package com.raul.block7crud.controllers;

import com.raul.block7crud.Application.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class BorrarPersona {
    @Autowired
    PersonaServiceImpl personaServiceimpl ;
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonaById(@PathVariable int id) {
        try {
            personaServiceimpl.deletePersonaById(id);
            return ResponseEntity.ok().body("persona with id: "+id+" was deleted");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }
}
