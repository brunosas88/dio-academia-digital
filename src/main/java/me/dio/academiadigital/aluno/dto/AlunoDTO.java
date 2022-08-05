package me.dio.academiadigital.aluno.dto;

import lombok.*;
import me.dio.academiadigital.aluno.model.Aluno;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlunoDTO {
    private String nome;
    private String cpf;
    private String endereco;
    private LocalDate dataDeNascimento;
    private Boolean ativo;

    public static AlunoDTO converterParaDTO (Aluno model) {
        return AlunoDTO.builder()
                .nome(model.getNome())
                .cpf(model.getCpf())
                .endereco(model.getEndereco())
                .dataDeNascimento(model.getDataDeNascimento())
                .ativo(model.getAtivo())
                .build();
    }
}
