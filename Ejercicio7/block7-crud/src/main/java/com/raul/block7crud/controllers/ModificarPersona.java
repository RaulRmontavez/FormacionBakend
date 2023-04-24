package com.raul.block7crud.controllers;

import com.raul.block7crud.Application.PersonaServiceImpl;
import com.raul.block7crud.controllers.dto.PersonaInputDto;
import com.raul.block7crud.controllers.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class ModificarPersona {
    @Autowired
    PersonaServiceImpl personaServiceimpl ;
    @PutMapping
    public ResponseEntity<PersonaOutputDto> updatePersona(@RequestBody PersonaInputDto persona) {
        try {
            personaServiceimpl.getPersonaById(persona.getId());
            return  ResponseEntity.ok().body(personaServiceimpl.addPersona(persona));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
