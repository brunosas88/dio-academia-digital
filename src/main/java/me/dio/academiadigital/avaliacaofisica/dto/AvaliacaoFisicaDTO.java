package me.dio.academiadigital.avaliacaofisica.dto;

import lombok.*;
import me.dio.academiadigital.avaliacaofisica.model.AvaliacaoFisica;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AvaliacaoFisicaDTO {
    private LocalDateTime dataDaAvaliacao;
    private Double peso;
    private Double altura;

    public static AvaliacaoFisicaDTO converterParaDTO (AvaliacaoFisica model) {
        return AvaliacaoFisicaDTO.builder()
                .dataDaAvaliacao(model.getDataDaAvaliacao())
                .peso(model.getPeso())
                .altura(model.getAltura())
                .build();
    }
}
