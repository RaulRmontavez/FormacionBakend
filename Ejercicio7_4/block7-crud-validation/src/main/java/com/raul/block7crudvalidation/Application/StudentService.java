package com.raul.block7crudvalidation.Application;



import com.raul.block7crudvalidation.clases.Alumnos_Estudios;
import com.raul.block7crudvalidation.controller.dto.*;

import java.util.List;

public interface StudentService {


    StudentOutputDto addStudent(StudentInputDto student) throws Exception;
    StudentOutputDto getStudentById(int id);
    StudentOutputDtoSimple getStudentByIdSimple(int id);
    // List<StudentOutputDto> getStudentByName(String name);
    Iterable<StudentOutputDto> getAllStudent(int pageNumber, int pageSize);
    StudentOutputDto updateStudent(StudentInputDto student, int id);
    void deleteStudentById( int id);

    StudentOutputDto addAsignatura(int id_asignatura, int id_student) throws Exception;
    StudentOutputDto addAsignaturas(List<Integer> id_asignatura, int id_student) throws Exception;

}
