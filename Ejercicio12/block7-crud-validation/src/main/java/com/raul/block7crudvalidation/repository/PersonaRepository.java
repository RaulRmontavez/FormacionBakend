package com.raul.block7crudvalidation.repository;

import com.raul.block7crudvalidation.clases.Persona;
import com.raul.block7crudvalidation.controller.dto.PersonaOutputDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona,Integer> {
    List<Persona> findByName(String name);
    List<Persona> findAll();
   // @Query("select p from Persona where s.name = ?1")
    //Persona getPersonaByLastName(String name);
   List<PersonaOutputDto> getCustomQuery(HashMap<String, Object> conditions,String ord);


}
