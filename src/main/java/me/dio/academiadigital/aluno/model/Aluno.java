package me.dio.academiadigital.aluno.model;

import me.dio.academiadigital.avaliacaofisica.model.AvaliacaoFisica;
import me.dio.academiadigital.matricula.model.Matricula;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column
    private String nome;
    @Column
    private String cpf;
    @Column
    private String endereco;
    @Column
    private LocalDate dataDeNascimento;

    List<AvaliacaoFisica> avaliacoes = new ArrayList<>();







}
