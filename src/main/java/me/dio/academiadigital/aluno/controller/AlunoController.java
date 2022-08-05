package me.dio.academiadigital.aluno.controller;

import lombok.RequiredArgsConstructor;
import me.dio.academiadigital.aluno.dto.AlunoDTO;
import me.dio.academiadigital.aluno.service.AlunoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<Page<AlunoDTO>> listarAlunos(@Nullable Pageable pageable) {
        return ResponseEntity.ok(alunoService.listarAlunos(pageable));
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> cadastrarAluno(@RequestBody AlunoDTO alunoDTO) {
        return ResponseEntity.ok(alunoService.cadastrarAluno(alunoDTO));
    }
}
