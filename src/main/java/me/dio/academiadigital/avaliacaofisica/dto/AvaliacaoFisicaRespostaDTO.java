package me.dio.academiadigital.avaliacaofisica.dto;

import lombok.*;
import me.dio.academiadigital.aluno.dto.AlunoRespostaDTO;
import me.dio.academiadigital.avaliacaofisica.model.AvaliacaoFisica;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AvaliacaoFisicaRespostaDTO {
    private LocalDateTime dataDaAvaliacao;
    private Double peso;
    private Double altura;
    private AlunoRespostaDTO aluno;

    public static AvaliacaoFisicaRespostaDTO converterParaDTO (AvaliacaoFisica model) {
        return AvaliacaoFisicaRespostaDTO.builder()
                .dataDaAvaliacao(model.getDataDaAvaliacao())
                .peso(model.getPeso())
                .altura(model.getAltura())
                .aluno(AlunoRespostaDTO.converterParaDTO(model.getAluno()))
                .build();
    }
}
