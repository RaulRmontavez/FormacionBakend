package com.raul.block7crudvalidation.Application;


import com.raul.block7crudvalidation.clases.Persona;
import com.raul.block7crudvalidation.controller.dto.PersonaInputDto;
import com.raul.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.raul.block7crudvalidation.exceptions.CustomError;
import com.raul.block7crudvalidation.exceptions.EntityNotFoundException;
import com.raul.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.raul.block7crudvalidation.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;


    @Override
    public PersonaOutputDto addPersona(PersonaInputDto persona) throws Exception {
        if (Objects.isNull(persona.getUsuario()) || persona.getUsuario().isBlank()) {
            throw new UnprocessableEntityException("El usuario no puede estar vacio");
        } else if (persona.getUsuario().length() > 10) {
            throw new UnprocessableEntityException("Longitud de usuario no puede ser superior a 10 caracteres");
        } else if (Objects.isNull(persona.getPassword())) {
            throw new UnprocessableEntityException("La contraseña no puede estar vacio");
        } else if (Objects.isNull(persona.getName())) {
            throw new UnprocessableEntityException("El nombre no puede estar vacio");
        } else if (Objects.isNull(persona.getSurname())) {
            throw new UnprocessableEntityException("El surname no puede estar vacio");
        } else if (Objects.isNull(persona.getCompany_email())) {
            throw new UnprocessableEntityException("La compañia de email no puede estar vacia");
        } else if (Objects.isNull(persona.getCity())) {
            throw new UnprocessableEntityException("La ciudad no puede estar vacia");
        } else if (Objects.isNull(persona.isActive())) {
            throw new UnprocessableEntityException("El activo no puede estar vacio");
        } else if (Objects.isNull(persona.getCreated_date())) {
            throw new UnprocessableEntityException("La fecha de creacion no puede estar vacia");
        } else if (Objects.isNull(persona.getImagen_url())) {
            throw new UnprocessableEntityException("La url de imagen no puede estar vacio");
        } else if (Objects.isNull(persona.getTermination_date())) {
            throw new UnprocessableEntityException("La fecha de finalizacion no puede estar vacio");
        } else {
            return personaRepository.save(new Persona(persona)).personaToPersonaOutputDto();
        }
    }

    @Override
    public PersonaOutputDto getPersonaById(int id) {
        Optional<Persona> personaOptional = personaRepository.findById(id);
        Persona persona = personaOptional.orElseThrow(() -> new EntityNotFoundException("No se ha encontrado a ninguna persona por ese id", 404));
        PersonaOutputDto personaOutputDto = persona.personaToPersonaOutputDto();
        return personaOutputDto;
    }

    @Override
    public List<PersonaOutputDto> getPersonaByName(String name) {
        if (personaRepository.findByName(name).stream().map(Persona::personaToPersonaOutputDto).collect(Collectors.toList()).size() == 0) {
            throw new EntityNotFoundException("No se ha encontrado a ninguna persona por ese nombre", 404);
        } else {
            return personaRepository.findByName(name).stream().map(Persona::personaToPersonaOutputDto).collect(Collectors.toList());
        }
    }


    @Override
    public List<PersonaOutputDto> getAllPersonas(int pageNumber, int pageSize) {

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        if (personaRepository.findAll(pageRequest).getContent().stream().map(Persona::personaToPersonaOutputDto).toList().size() == 0) {
            throw new EntityNotFoundException("No se ha encontrado a ninguna persona", 404);
        } else {
            return personaRepository.findAll(pageRequest).getContent().stream().map(Persona::personaToPersonaOutputDto).toList();
        }
    }


}
