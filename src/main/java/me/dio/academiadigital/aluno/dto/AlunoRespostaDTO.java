package me.dio.academiadigital.aluno.dto;

import lombok.*;
import me.dio.academiadigital.aluno.model.Aluno;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlunoRespostaDTO {
    @NotBlank(message = "Insira o campo '${validatedValue)' do aluno corretamente")
    @Size(min=3, max=50, message = "'${validatedValue)' deve conter entre {min} e {max} caracteres")
    private String nome;

    @NotEmpty(message = "Insira o campo '${validatedValue)' do aluno corretamente")
    //@CPF(message = "'${validatedValue}' é inválido!")
    private String cpf;

    @NotBlank(message = "Insira o campo '${validatedValue)' do aluno corretamente")
    @Size(min=3, max=50, message = "'${validatedValue)' deve conter entre {min} e {max} caracteres")
    private String endereco;

    @NotNull(message = "Insira o campo '${validatedValue)' do aluno corretamente")
    private LocalDate dataDeNascimento;

    private Boolean ativo;

    public static AlunoRespostaDTO converterParaDTO (Aluno model) {
        return AlunoRespostaDTO.builder()
                .nome(model.getNome())
                .cpf(model.getCpf())
                .endereco(model.getEndereco())
                .dataDeNascimento(model.getDataDeNascimento())
                .ativo(model.getAtivo())
                .build();
    }
}
