package com.raul.block7crudvalidation.repository;

import com.raul.block7crudvalidation.clases.Profesor;
import com.raul.block7crudvalidation.clases.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findAll();

}
