package me.dio.academiadigital.matricula.dto;

import me.dio.academiadigital.aluno.model.Aluno;

import java.time.LocalDateTime;
import java.util.UUID;

public class RespostaMatricula {
    private UUID matriculaId;
    private LocalDateTime dataDaMatricula;
    private Aluno aluno;
}
