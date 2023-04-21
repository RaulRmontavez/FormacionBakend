package com.raul.block7crud;

public interface StudentService {

    StudentOutputDto addStudent(StudentInputDto student);
    StudentOutputDto getStudentById(int id);
    void deleteStudentById( int id);
    Iterable<StudentOutputDto> getAllStudents(int pageNumber, int pageSize);
    StudentOutputDto updateStudent(StudentInputDto student);
}
