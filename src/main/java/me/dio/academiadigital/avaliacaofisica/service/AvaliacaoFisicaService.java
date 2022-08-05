package me.dio.academiadigital.avaliacaofisica.service;

import lombok.RequiredArgsConstructor;
import me.dio.academiadigital.aluno.model.Aluno;
import me.dio.academiadigital.aluno.service.AlunoService;
import me.dio.academiadigital.avaliacaofisica.dto.AvaliacaoFisicaRequisicao;
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
    public AvaliacaoFisica salvarAvaliacaoFisica(AvaliacaoFisicaRequisicao avaliacaoFisicaRequisicao) {
        Aluno alunoCadastrado = alunoService.buscarAluno(avaliacaoFisicaRequisicao.getCpf());
        AvaliacaoFisica novaAvaliacacaoFisica = new AvaliacaoFisica();
        novaAvaliacacaoFisica.setAltura(avaliacaoFisicaRequisicao.getAltura());
        novaAvaliacacaoFisica.setPeso(avaliacaoFisicaRequisicao.getPeso());
        novaAvaliacacaoFisica.setAluno(alunoCadastrado);
        novaAvaliacacaoFisica = avaliacaoFisicaRepository.save(novaAvaliacacaoFisica);

        alunoCadastrado.getAvaliacoes().add(novaAvaliacacaoFisica);
        alunoService.atualizarCadastroDeAluno(alunoCadastrado);

        return novaAvaliacacaoFisica;
    }

}
