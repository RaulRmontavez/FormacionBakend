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
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;


    @Override
    public PersonaOutputDto addPersona(PersonaInputDto persona) throws Exception {
        if (Objects.isNull(persona.getUsuario()) || persona.getUsuario().isBlank()){throw new Exception("El usuario no puede estar vacio");}
        else if (persona.getUsuario().length()>10){throw new Exception("Longitud de usuario no puede ser superior a 10 caracteres");}
        else if (Objects.isNull(persona.getPassword())){throw new Exception("La contraseña no puede estar vacio");}
        else if (Objects.isNull(persona.getName())){throw new Exception("El nombre no puede estar vacio");}
        else if (Objects.isNull(persona.getSurname())){throw new Exception("El surname no puede estar vacio");}
        else if (Objects.isNull(persona.getCompany_email())){throw new Exception("La compañia de email no puede estar vacia");}
        else if (Objects.isNull(persona.getCity())){throw new Exception("La ciudad no puede estar vacia");}
        else if (Objects.isNull(persona.isActive())){throw new Exception("El activo no puede estar vacio");}
        else if (Objects.isNull(persona.getCreated_date())){throw new Exception("La fecha de creacion no puede estar vacia");}
        else if (Objects.isNull(persona.getImagen_url())){throw new Exception("La url de imagen no puede estar vacio");}
        else if (Objects.isNull(persona.getTermination_date())){throw new Exception("La fecha de finalizacion no puede estar vacio");}
        else {
            return personaRepository.save(new Persona(persona)).personaToPersonaOutputDto();
        }
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
