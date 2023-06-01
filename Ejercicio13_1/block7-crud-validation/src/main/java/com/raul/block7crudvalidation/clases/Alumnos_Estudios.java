package com.raul.block7crudvalidation.clases;

import com.raul.block7crudvalidation.controller.dto.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "estudios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alumnos_Estudios {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_study;
    @ManyToOne
    @JoinColumn(name = "profesor_id")
    Profesor profesor;
    @ManyToMany
    List<Student> student;
    @Column(name = "asignatura")
    String asignatura;
    @Column(name = "comentarios")
    String comment;
    @Column(name = "initial_date")
    Date initial_date;
    @Column(name = "finish_date")
    Date finish_date;

    /**
     * Constructores
     * @param id_asignatura
     */
    public Alumnos_Estudios(int id_asignatura) {
        this.id_study = id_asignatura;
    }

    public Alumnos_Estudios(Alumnos_EstudiosInputDto alumnos_estudios) {

        asignatura = alumnos_estudios.getAsignatura();
        comment = alumnos_estudios.getComment();
        initial_date = alumnos_estudios.getInitial_date();
        finish_date = alumnos_estudios.getFinish_date();

    }


    //Convertir input a output
    public Alumnos_EstudiosOutputDto asignaturaToAlumnoOutputDto() {
        List<StudentOutputDtoSimple> students = new ArrayList<>();
        if (student != null) {
            for (Student estudiante : student) {
                students.add(estudiante.StudentOutputDtoSimple());
            }
        }

        return new Alumnos_EstudiosOutputDto(this.id_study,this.profesor,students,this.asignatura,this.comment,this.initial_date,this.finish_date);
    }


    public Alumnos_EstudiosOutputDtoSimple Alumnos_EstudiosOutputDtoSimple() {
        return new Alumnos_EstudiosOutputDtoSimple(this.id_study,this.asignatura,this.comment,this.initial_date,this.finish_date);
    }
}

