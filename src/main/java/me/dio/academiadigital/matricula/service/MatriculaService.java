package me.dio.academiadigital.matricula.service;

import lombok.RequiredArgsConstructor;
import me.dio.academiadigital.aluno.model.Aluno;
import me.dio.academiadigital.matricula.dto.MatriculaRespostaDTO;
import me.dio.academiadigital.matricula.model.Matricula;
import me.dio.academiadigital.matricula.repository.MatriculaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public void realizarMatricula(Aluno aluno) {
        Matricula novaMatricula = new Matricula();
        novaMatricula.setMatriculaId(UUID.randomUUID().toString());
        novaMatricula.setAluno(aluno);
        matriculaRepository.save(novaMatricula);
    }

    public Page<MatriculaRespostaDTO> listarMatriculas(Pageable pageable) {
        return matriculaRepository.findAll(pageable).map(MatriculaRespostaDTO::converterParaDTO);
    }

    public Page<MatriculaRespostaDTO> buscarMatriculaPorEndereco(String endereco) {
        return (endereco != null) ?
                matriculaRepository.findAlunosMatriculadosEndereco(endereco, Pageable.unpaged()).map(MatriculaRespostaDTO::converterParaDTO)
                : listarMatriculas(Pageable.unpaged());
    }

    public void deletarMatricula(String cpf) {
        matriculaRepository.delete(matriculaRepository.findByAlunoCpf(cpf));
    }

    public Page<MatriculaRespostaDTO> buscarMatriculas(String cpf, String matriculaId) {
        return (cpf != null) ?
                new PageImpl(Collections.singletonList(MatriculaRespostaDTO.converterParaDTO(matriculaRepository.findByAlunoCpf(cpf))), Pageable.unpaged(), 1 )
                : (matriculaId != null) ?
                        new PageImpl(Collections.singletonList(MatriculaRespostaDTO.converterParaDTO(matriculaRepository.findByMatriculaId(matriculaId))), Pageable.unpaged(), 1 )
                        : matriculaRepository.findAll(Pageable.unpaged()).map(MatriculaRespostaDTO::converterParaDTO);
    }
}
