package com.raul.block7crudvalidation.Application;



import com.raul.block7crudvalidation.clases.Persona;
import com.raul.block7crudvalidation.controllers.dto.PersonaInputDto;
import com.raul.block7crudvalidation.controllers.dto.PersonaOutputDto;
import com.raul.block7crudvalidation.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;


    @Override
    public PersonaOutputDto addPersona(PersonaInputDto persona) {
        return personaRepository.save(new Persona(persona)).personaToPersonaOutputDto();
    }

    @Override
    public PersonaOutputDto getPersonaById(int id) {
        return personaRepository.findById(id).orElseThrow().personaToPersonaOutputDto();
    }

    @Override
    public List<PersonaOutputDto> getPersonaByName(String name) {
        return personaRepository.findByName(name).stream().map(Persona::personaToPersonaOutputDto).collect(Collectors.toList());
    }

    @Override
    public List<PersonaOutputDto> getPersonaAll() {
        return personaRepository.findAll().stream().map(Persona::personaToPersonaOutputDto).collect(Collectors.toList());
    }


    @Override
    public List<PersonaOutputDto> getAllPersonas(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return personaRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Persona::personaToPersonaOutputDto).toList();
    }


}
