package com.raul.block7crudvalidation.repository;

import com.raul.block7crudvalidation.clases.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona,Integer> {
    List<Persona> findByName(String name);
    List<Persona> findAll();


}
