package me.dio.academiadigital.aluno.service;

import lombok.RequiredArgsConstructor;
import me.dio.academiadigital.aluno.dto.AlunoDTO;
import me.dio.academiadigital.aluno.model.Aluno;
import me.dio.academiadigital.aluno.repository.AlunoRepository;
import me.dio.academiadigital.matricula.service.MatriculaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final MatriculaService matriculaService;

    public AlunoDTO cadastrarAluno(AlunoDTO alunoDTO) {
        Aluno alunoCadastrado = alunoRepository.save(Aluno.converterParaModelo(alunoDTO));
        matriculaService.realizarMatricula(alunoCadastrado);
        return AlunoDTO.converterParaDTO(alunoCadastrado);
    }

    public Page<AlunoDTO> listarAlunos(Pageable pageable) {
        return alunoRepository.findAll(pageable).map(AlunoDTO::converterParaDTO);
    }

    public Aluno buscarAluno(String cpf) {
        return alunoRepository.findByCpf(cpf);
    }

    public void atualizarCadastroDeAluno(Aluno alunoParaAtualizar) {
        alunoRepository.save(alunoParaAtualizar);
    }
}
