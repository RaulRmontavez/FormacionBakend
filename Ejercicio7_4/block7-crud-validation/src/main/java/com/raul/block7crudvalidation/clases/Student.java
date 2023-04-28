package com.raul.block7crudvalidation.clases;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "estudiantes")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_student;
   // @OneToOne
  //  @JoinColumn(name = "id_persona")
    Persona persona;
   // @Column(name = "horas_por_semana")
    Integer num_hours_week;
  //  @Column(name = "comentarios")
    String coments;
  //  @ManyToOne(fetch = FetchType.LAZY)
  //  @JoinColumn(name = "id_profesor")
    Profesor profesor;
  //  @Column(name = "rama")
    String branch;
   // @OneToMany
    List<Alumnos_Estudios> estudios;
}