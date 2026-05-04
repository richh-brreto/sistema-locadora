package com.example.locadora_filmes.controller;

import com.example.locadora_filmes.DTO.filme.FilmeRequest;
import com.example.locadora_filmes.DTO.filme.FilmeResponse;
import com.example.locadora_filmes.model.Filme;
import com.example.locadora_filmes.service.FilmeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeService filmeService;

    @GetMapping
    @Tag(name = "Listar filmes")
    @Operation(summary = "Listar filmes do banco de dados", description = "Usa o 'listar' do FilmeService")
    public List<Filme> listar(){
        return filmeService.listar();
    }

    @PostMapping
    @Tag(name = "Cadastrar filmes")
    @Operation(summary = "Cadastrar filmes no banco de dados", description = "Usa o 'cadastrar' do FilmeService")
    public ResponseEntity<FilmeResponse> cadastrar(@RequestBody FilmeRequest request){
        return ResponseEntity.status(201).body(filmeService.cadastrar(request));
    }
}
