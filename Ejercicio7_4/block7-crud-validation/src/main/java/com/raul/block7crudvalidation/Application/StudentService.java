package com.raul.block7crudvalidation.Application;



import com.raul.block7crudvalidation.controller.dto.PersonaInputDto;
import com.raul.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.raul.block7crudvalidation.controller.dto.StudentInputDto;
import com.raul.block7crudvalidation.controller.dto.StudentOutputDto;

import java.util.List;

public interface StudentService {


    StudentOutputDto addStudent(StudentInputDto student) throws Exception;
    StudentOutputDto getStudentById(int id);
   // List<StudentOutputDto> getStudentByName(String name);
    Iterable<StudentOutputDto> getAllStudent(int pageNumber, int pageSize);
    StudentOutputDto updateStudent(StudentInputDto student, int id);
    void deleteStudentById( int id);

}
