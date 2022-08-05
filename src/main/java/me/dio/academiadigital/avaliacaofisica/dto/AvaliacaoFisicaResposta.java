package me.dio.academiadigital.avaliacaofisica.dto;

import lombok.*;
import me.dio.academiadigital.aluno.dto.AlunoDTO;
import me.dio.academiadigital.avaliacaofisica.model.AvaliacaoFisica;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AvaliacaoFisicaResposta {
    private LocalDateTime dataDaAvaliacao;
    private Double peso;
    private Double altura;
    private AlunoDTO aluno;

    public static AvaliacaoFisicaResposta converterParaDTO (AvaliacaoFisica model) {
        return AvaliacaoFisicaResposta.builder()
                .dataDaAvaliacao(model.getDataDaAvaliacao())
                .peso(model.getPeso())
                .altura(model.getAltura())
                .aluno(AlunoDTO.converterParaDTO(model.getAluno()))
                .build();
    }
}
