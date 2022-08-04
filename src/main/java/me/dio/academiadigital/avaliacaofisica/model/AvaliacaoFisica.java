package me.dio.academiadigital.avaliacaofisica.model;

import me.dio.academiadigital.aluno.model.Aluno;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class AvaliacaoFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column
    private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

    @Column
    private Double peso;

    @Column
    private Double altura;

    private Aluno aluno;

}
