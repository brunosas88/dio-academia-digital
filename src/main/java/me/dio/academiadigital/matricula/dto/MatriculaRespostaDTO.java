package me.dio.academiadigital.matricula.dto;

import lombok.*;
import me.dio.academiadigital.aluno.dto.AlunoRespostaDTO;
import me.dio.academiadigital.matricula.model.Matricula;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatriculaRespostaDTO {
    private String matriculaId;
    private LocalDateTime dataDaMatricula;
    private AlunoRespostaDTO aluno;

    public static MatriculaRespostaDTO converterParaDTO(Matricula model) {
        return MatriculaRespostaDTO.builder()
                .matriculaId(model.getMatriculaId())
                .dataDaMatricula(model.getDataDaMatricula())
                .aluno(AlunoRespostaDTO.converterParaDTO(model.getAluno()))
                .build();
    }
}
