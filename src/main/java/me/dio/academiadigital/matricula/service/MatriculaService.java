package me.dio.academiadigital.matricula.service;

import lombok.RequiredArgsConstructor;
import me.dio.academiadigital.aluno.model.Aluno;
import me.dio.academiadigital.matricula.dto.RespostaMatricula;
import me.dio.academiadigital.matricula.model.Matricula;
import me.dio.academiadigital.matricula.repository.MatriculaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public void realizarMatricula(Aluno aluno) {
        Matricula novaMatricula = new Matricula();
        novaMatricula.setMatriculaId(UUID.randomUUID());
        novaMatricula.setAluno(aluno);
        matriculaRepository.save(novaMatricula);
    }

    public Page<RespostaMatricula> listarMatriculas(Pageable pageable) {
        return matriculaRepository.findAll(pageable).map(RespostaMatricula::converterParaDTO);
    }
}
