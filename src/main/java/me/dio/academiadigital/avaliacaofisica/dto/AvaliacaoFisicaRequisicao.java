package me.dio.academiadigital.avaliacaofisica.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoFisicaRequisicao {
    private String cpf;
    private Double peso;
    private Double altura;
}
