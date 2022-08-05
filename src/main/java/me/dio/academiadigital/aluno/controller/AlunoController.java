package me.dio.academiadigital.aluno.controller;

import lombok.RequiredArgsConstructor;
import me.dio.academiadigital.aluno.dto.AlunoAtualizacaoDeDadosDTO;
import me.dio.academiadigital.aluno.dto.AlunoRespostaDTO;
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
    public ResponseEntity<Page<AlunoRespostaDTO>> listarAlunos(@Nullable Pageable pageable) {
        return ResponseEntity.ok(alunoService.listarAlunos(pageable));
    }

    @PostMapping
    public ResponseEntity<AlunoRespostaDTO> cadastrarAluno(@RequestBody AlunoRespostaDTO alunoRespostaDTO) {
        return ResponseEntity.ok(alunoService.cadastrarAluno(alunoRespostaDTO));
    }

    @PatchMapping("/desativar")
    public void desativarAluno(@RequestParam(value = "cpf") String cpf ) {
        alunoService.desativarAluno(cpf);
    }

    @PatchMapping("/atualizar-endereco")
    public ResponseEntity<AlunoRespostaDTO> atualizarDadosAluno(@RequestParam(value = "cpf") String cpf, @RequestBody AlunoAtualizacaoDeDadosDTO alunoAtualizacaoDeDadosDTO ) {
        return ResponseEntity.ok(alunoService.atualizarDadosAluno(cpf, alunoAtualizacaoDeDadosDTO));
    }
}
