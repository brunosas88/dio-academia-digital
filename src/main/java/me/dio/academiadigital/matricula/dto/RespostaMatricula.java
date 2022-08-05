package me.dio.academiadigital.matricula.dto;

import lombok.*;
import me.dio.academiadigital.aluno.dto.AlunoDTO;
import me.dio.academiadigital.matricula.model.Matricula;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespostaMatricula {
    private String matriculaId;
    private LocalDateTime dataDaMatricula;
    private AlunoDTO aluno;

    public static RespostaMatricula converterParaDTO(Matricula model) {
        return RespostaMatricula.builder()
                .matriculaId(model.getMatriculaId())
                .dataDaMatricula(model.getDataDaMatricula())
                .aluno(AlunoDTO.converterParaDTO(model.getAluno()))
                .build();
    }
}
