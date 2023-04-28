package com.raul.block7crudvalidation.clases;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "profesor")
@Data
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_profesor;
  //  @OneToOne
    //@JoinColumn(name = "id_persona")
    Persona persona;
  //  @Column(name = "comentarios")
    String coments;
   // @OneToMany(fetch = FetchType.LAZY)
   // @JoinColumn(name = "id_students")
    Alumnos_Estudios alumnosEstudios;
   // @Column(name = "rama")
    String branch;
    //@OneToMany
    List<Alumnos_Estudios> estudios;
}