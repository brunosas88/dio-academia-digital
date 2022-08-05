package me.dio.academiadigital.matricula.controller;

import lombok.RequiredArgsConstructor;
import me.dio.academiadigital.matricula.dto.RespostaMatricula;
import me.dio.academiadigital.matricula.service.MatriculaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    @GetMapping
    public ResponseEntity<Page<RespostaMatricula>> listarMatriculas(@Nullable Pageable pageable) {
        return ResponseEntity.ok(matriculaService.listarMatriculas(pageable));
    }

    @DeleteMapping("/deletar")
    public void deletarMatricula(@RequestParam(value = "cpf") String cpf ) {
        matriculaService.deletarMatricula(cpf);
    }
}
