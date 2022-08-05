package me.dio.academiadigital.avaliacaofisica.controller;

import lombok.RequiredArgsConstructor;
import me.dio.academiadigital.avaliacaofisica.dto.AvaliacaoFisicaRequisicaoDTO;
import me.dio.academiadigital.avaliacaofisica.dto.AvaliacaoFisicaRespostaDTO;
import me.dio.academiadigital.avaliacaofisica.service.AvaliacaoFisicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/avaliacao-fisica")
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    public ResponseEntity<AvaliacaoFisicaRespostaDTO> cadastrarAvaliacaoFisica(@RequestBody AvaliacaoFisicaRequisicaoDTO avaliacaoFisicaRequisicaoDTO) {
        return ResponseEntity.ok(avaliacaoFisicaService.salvarAvaliacaoFisica(avaliacaoFisicaRequisicaoDTO));
    }




}
