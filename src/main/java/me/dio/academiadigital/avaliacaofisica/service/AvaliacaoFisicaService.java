package me.dio.academiadigital.avaliacaofisica.service;

import lombok.RequiredArgsConstructor;
import me.dio.academiadigital.aluno.model.Aluno;
import me.dio.academiadigital.aluno.service.AlunoService;
import me.dio.academiadigital.avaliacaofisica.dto.AvaliacaoFisicaRequisicaoDTO;
import me.dio.academiadigital.avaliacaofisica.dto.AvaliacaoFisicaRespostaDTO;
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
    public AvaliacaoFisicaRespostaDTO salvarAvaliacaoFisica(AvaliacaoFisicaRequisicaoDTO requisicao) {
        Aluno alunoCadastrado = alunoService.buscarAluno(requisicao.getCpf());
        AvaliacaoFisica novaAvaliacacaoFisica = criarAvaliacaoFisica(requisicao, alunoCadastrado);
        novaAvaliacacaoFisica = avaliacaoFisicaRepository.save(novaAvaliacacaoFisica);
        cadastrarAvaliacaoFisicaEmAluno(alunoCadastrado, novaAvaliacacaoFisica);
        return AvaliacaoFisicaRespostaDTO.converterParaDTO(novaAvaliacacaoFisica);
    }

    private void cadastrarAvaliacaoFisicaEmAluno(Aluno alunoCadastrado, AvaliacaoFisica novaAvaliacacaoFisica) {
        alunoCadastrado.getAvaliacoes().add(novaAvaliacacaoFisica);
        alunoService.atualizarAvaliacaoFisicaDoAluno(alunoCadastrado);
    }

    private AvaliacaoFisica criarAvaliacaoFisica(AvaliacaoFisicaRequisicaoDTO requisicao, Aluno alunoCadastrado) {
        AvaliacaoFisica novaAvaliacacaoFisica = new AvaliacaoFisica();
        novaAvaliacacaoFisica.setAltura(requisicao.getAltura());
        novaAvaliacacaoFisica.setPeso(requisicao.getPeso());
        novaAvaliacacaoFisica.setAluno(alunoCadastrado);
        return novaAvaliacacaoFisica;
    }

}
