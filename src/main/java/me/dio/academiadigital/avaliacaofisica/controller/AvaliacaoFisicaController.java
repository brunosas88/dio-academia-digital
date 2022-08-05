package me.dio.academiadigital.avaliacaofisica.controller;

import lombok.RequiredArgsConstructor;
import me.dio.academiadigital.avaliacaofisica.dto.AvaliacaoFisicaRequisicao;
import me.dio.academiadigital.avaliacaofisica.model.AvaliacaoFisica;
import me.dio.academiadigital.avaliacaofisica.service.AvaliacaoFisicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/avaliacao-fisica")
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    public ResponseEntity<AvaliacaoFisica> cadastrarAvaliacaoFisica(@RequestBody AvaliacaoFisicaRequisicao avaliacaoFisicaRequisicao) {
        return ResponseEntity.ok(avaliacaoFisicaService.salvarAvaliacaoFisica(avaliacaoFisicaRequisicao));
    }




}
