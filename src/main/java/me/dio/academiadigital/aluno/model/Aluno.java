package me.dio.academiadigital.aluno.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import me.dio.academiadigital.aluno.dto.AlunoDTO;
import me.dio.academiadigital.avaliacaofisica.model.AvaliacaoFisica;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "aluno")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(unique = true)
    private String cpf;

    private String endereco;

    private LocalDate dataDeNascimento;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    List<AvaliacaoFisica> avaliacoes  = new ArrayList<>();

    public static Aluno converterParaModelo (AlunoDTO dto) {
        return Aluno.builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .endereco(dto.getEndereco())
                .dataDeNascimento(dto.getDataDeNascimento())
                .avaliacoes(new ArrayList<>())
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id) && Objects.equals(nome, aluno.nome) && Objects.equals(cpf, aluno.cpf) && Objects.equals(endereco, aluno.endereco) && Objects.equals(dataDeNascimento, aluno.dataDeNascimento) && Objects.equals(avaliacoes, aluno.avaliacoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, endereco, dataDeNascimento, avaliacoes);
    }
}
