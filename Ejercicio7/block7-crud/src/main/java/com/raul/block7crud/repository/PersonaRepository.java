package com.raul.block7crud.repository;

import com.raul.block7crud.clases.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona,Integer> {

    //List<Persona> findByNombre(String nombre);
}
