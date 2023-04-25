package com.raul.block7crudvalidation.controllers.dto;


import com.raul.block7crudvalidation.Application.PersonaService;
import com.raul.block7crudvalidation.Application.PersonaServiceImpl;
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
    PersonaService personaService;


    @PostMapping
    public ResponseEntity<PersonaOutputDto> addPersona(@RequestBody PersonaInputDto persona) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.addPersona(persona));
    }


}
