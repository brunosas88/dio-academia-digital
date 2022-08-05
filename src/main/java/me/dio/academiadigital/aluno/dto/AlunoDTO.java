package me.dio.academiadigital.aluno.dto;

import lombok.*;
import me.dio.academiadigital.aluno.model.Aluno;
import me.dio.academiadigital.avaliacaofisica.dto.AvaliacaoFisicaDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private List<AvaliacaoFisicaDTO> avaliacoesFisicas = new ArrayList<>();

    public static AlunoDTO converterParaDTO (Aluno model) {
        return AlunoDTO.builder()
                .nome(model.getNome())
                .cpf(model.getCpf())
                .endereco(model.getEndereco())
                .dataDeNascimento(model.getDataDeNascimento())
                .avaliacoesFisicas(model.getAvaliacoes().stream().map(AvaliacaoFisicaDTO::converterParaDTO).collect(Collectors.toList()))
                .build();
    }
}
