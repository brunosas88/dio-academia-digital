package me.dio.academiadigital.avaliacaofisica.service;

import lombok.RequiredArgsConstructor;
import me.dio.academiadigital.aluno.model.Aluno;
import me.dio.academiadigital.aluno.service.AlunoService;
import me.dio.academiadigital.avaliacaofisica.dto.AvaliacaoFisicaRequisicao;
import me.dio.academiadigital.avaliacaofisica.dto.AvaliacaoFisicaResposta;
import me.dio.academiadigital.avaliacaofisica.model.AvaliacaoFisica;
import me.dio.academiadigital.avaliacaofisica.repository.AvaliacaoFisicaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    private final AlunoService alunoService;
    @Transactional
    public AvaliacaoFisicaResposta salvarAvaliacaoFisica(AvaliacaoFisicaRequisicao requisicao) {
        Aluno alunoCadastrado = alunoService.buscarAluno(requisicao.getCpf());
        AvaliacaoFisica novaAvaliacacaoFisica = criarAvaliacaoFisica(requisicao, alunoCadastrado);
        novaAvaliacacaoFisica = avaliacaoFisicaRepository.save(novaAvaliacacaoFisica);
        cadastrarAvaliacaoFisicaEmAluno(alunoCadastrado, novaAvaliacacaoFisica);
        return AvaliacaoFisicaResposta.converterParaDTO(novaAvaliacacaoFisica);
    }

    private void cadastrarAvaliacaoFisicaEmAluno(Aluno alunoCadastrado, AvaliacaoFisica novaAvaliacacaoFisica) {
        alunoCadastrado.getAvaliacoes().add(novaAvaliacacaoFisica);
        alunoService.atualizarCadastroDeAluno(alunoCadastrado);
    }

    private AvaliacaoFisica criarAvaliacaoFisica(AvaliacaoFisicaRequisicao requisicao, Aluno alunoCadastrado) {
        AvaliacaoFisica novaAvaliacacaoFisica = new AvaliacaoFisica();
        novaAvaliacacaoFisica.setAltura(requisicao.getAltura());
        novaAvaliacacaoFisica.setPeso(requisicao.getPeso());
        novaAvaliacacaoFisica.setAluno(alunoCadastrado);
        return novaAvaliacacaoFisica;
    }

}
