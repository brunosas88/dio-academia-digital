package me.dio.academiadigital.avaliacaofisica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoFisicaRequisicaoDTO {
    @NotBlank(message = "Insira o campo '${validatedValue)' do aluno corretamente")
    //@CPF(message = "'${validatedValue}' é inválido!")
    private String cpf;
    @NotNull
    @Positive(message = "Insira no campo '${validatedValue)' um valor acima de zero")
    private Double peso;

    @Positive(message = "Insira no campo '${validatedValue)' um valor acima de zero")
    private Double altura;
}
