package com.raul.block7crud.controllers;

import com.raul.block7crud.Application.PersonaServiceImpl;
import com.raul.block7crud.controllers.dto.PersonaInputDto;
import com.raul.block7crud.controllers.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class AgregarPersona {

    @Autowired
    PersonaServiceImpl personaServiceimpl ;


    @PostMapping
    public ResponseEntity<PersonaOutputDto> addPersona(@RequestBody PersonaInputDto persona) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personaServiceimpl.addPersona(persona));
    }


}
