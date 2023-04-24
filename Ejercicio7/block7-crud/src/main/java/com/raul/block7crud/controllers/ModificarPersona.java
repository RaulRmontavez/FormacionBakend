package com.raul.block7crud.controllers;

import com.raul.block7crud.Application.PersonaServiceImpl;
import com.raul.block7crud.controllers.dto.PersonaInputDto;
import com.raul.block7crud.controllers.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class ModificarPersona {
    @Autowired
    PersonaServiceImpl personaServiceimpl ;
    @PutMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> updatePersona(@RequestBody PersonaInputDto persona, @PathVariable int id) {
        try {
            personaServiceimpl.getPersonaById(id);
            personaServiceimpl.updatePersona(persona,id);
            return  ResponseEntity.ok().body(personaServiceimpl.getPersonaById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
