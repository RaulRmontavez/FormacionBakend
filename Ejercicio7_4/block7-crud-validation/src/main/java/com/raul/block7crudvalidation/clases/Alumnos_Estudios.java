package com.raul.block7crudvalidation.clases;

import com.raul.block7crudvalidation.controller.dto.Alumnos_EstudiosInputDto;
import com.raul.block7crudvalidation.controller.dto.Alumnos_EstudiosOutputDto;
import com.raul.block7crudvalidation.controller.dto.PersonaInputDto;
import com.raul.block7crudvalidation.controller.dto.PersonaOutputDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @OneToMany(cascade = CascadeType.ALL)
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
        return new Alumnos_EstudiosOutputDto(this.id_study,this.profesor,this.student,this.asignatura,this.comment,this.initial_date,this.finish_date);
    }

}

