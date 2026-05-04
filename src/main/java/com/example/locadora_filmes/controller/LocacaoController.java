package com.example.locadora_filmes.controller;

import com.example.locadora_filmes.DTO.locacao.LocacaoRequest;
import com.example.locadora_filmes.model.Locacao;
import com.example.locadora_filmes.service.LocacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {
    private final LocacaoService locacaoService;

    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    @GetMapping
    @Tag(name = "Listar locações")
    @Operation(summary = "Listar locações do banco de dados", description = "Usa o 'listar' do LocacaoService")
    public List<Locacao> listar() {
        return locacaoService.listar();
    }

    @PostMapping
    @Tag(name = "Cadastrar locações")
    @Operation(summary = "Cadastrar locações do banco de dados", description = "Usa o 'cadastrar' do LocacaoService")
    public Locacao registrar (@RequestBody LocacaoRequest request) {
        return locacaoService.registrarLocacao(request);
    }

    @PutMapping("/{id}/devolucao")
    @Tag(name = "Atualizar locação")
    @Operation(summary = "Atualizar locações no banco de dados", description = "Usa o 'atualizar' do LocacaoService, e 'devolve' um filme")
    public ResponseEntity<Locacao> devolver (@PathVariable Long id) {
        return ResponseEntity.status(201).body(locacaoService.devolver(id));
    }
}
