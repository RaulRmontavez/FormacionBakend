package com.raul.block7crudvalidation.repository;

import com.raul.block7crudvalidation.clases.Alumnos_Estudios;
import com.raul.block7crudvalidation.clases.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlumnosEstudiosRepository extends JpaRepository<Alumnos_Estudios,Integer> {
    List<Alumnos_Estudios> findAll();

}
