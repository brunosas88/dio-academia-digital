package me.dio.academiadigital.aluno.service;

import lombok.RequiredArgsConstructor;
import me.dio.academiadigital.aluno.dto.AlunoRespostaDTO;
import me.dio.academiadigital.aluno.model.Aluno;
import me.dio.academiadigital.aluno.repository.AlunoRepository;
import me.dio.academiadigital.matricula.service.MatriculaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final MatriculaService matriculaService;
    @Transactional
    public AlunoRespostaDTO cadastrarAluno(AlunoRespostaDTO alunoRespostaDTO) {
        Aluno alunoCadastrado = alunoRepository.save(Aluno.converterParaModelo(alunoRespostaDTO));
        matriculaService.realizarMatricula(alunoCadastrado);
        return AlunoRespostaDTO.converterParaDTO(alunoCadastrado);
    }

    public Page<AlunoRespostaDTO> listarAlunos(Pageable pageable) {
        return alunoRepository.findAll(pageable).map(AlunoRespostaDTO::converterParaDTO);
    }

    public Aluno buscarAluno(String cpf) {
        return alunoRepository.findByCpf(cpf);
    }

    public void atualizarAvaliacaoFisicaDoAluno(Aluno alunoParaAtualizar) {
        alunoRepository.save(alunoParaAtualizar);
    }

    public void desativarAluno(String cpf) {
        Aluno alunoADesativar = buscarAluno(cpf);
        alunoADesativar.setAtivo(false);
        alunoRepository.save(alunoADesativar);
    }

    public void deletarAluno(String cpf) {
        Aluno alunoADeletar = buscarAluno(cpf);
        alunoRepository.delete(alunoADeletar);
    }
}
