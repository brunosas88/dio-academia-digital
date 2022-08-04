package me.dio.academiadigital.matricula.model;

import me.dio.academiadigital.aluno.model.Aluno;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column
    private UUID matriculaId;

    @Column
    private LocalDateTime dataDaMatricula = LocalDateTime.now();

    private Aluno aluno;

}
