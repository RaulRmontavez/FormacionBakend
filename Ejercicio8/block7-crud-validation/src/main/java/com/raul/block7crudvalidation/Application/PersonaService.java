package com.raul.block7crudvalidation.Application;



import com.raul.block7crudvalidation.controllers.dto.PersonaInputDto;
import com.raul.block7crudvalidation.controllers.dto.PersonaOutputDto;

import java.util.List;

public interface PersonaService {


    PersonaOutputDto addPersona(PersonaInputDto persona);
    PersonaOutputDto getPersonaById(int id);
    List<PersonaOutputDto> getPersonaByName(String name);
    List<PersonaOutputDto> getPersonaAll();
    Iterable<PersonaOutputDto> getAllPersonas(int pageNumber, int pageSize);

}
