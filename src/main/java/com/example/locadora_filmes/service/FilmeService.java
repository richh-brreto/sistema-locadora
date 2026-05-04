package com.example.locadora_filmes.service;

import com.example.locadora_filmes.DTO.filme.FilmeRequest;
import com.example.locadora_filmes.DTO.filme.FilmeResponse;
import com.example.locadora_filmes.mapper.ClienteMapper;
import com.example.locadora_filmes.mapper.FilmeMapper;
import com.example.locadora_filmes.model.Filme;
import com.example.locadora_filmes.repository.FilmeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequestMapping("/filmes")
public class FilmeService {
    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public List<Filme> listar(){
        return filmeRepository.findAll();
    }

    public FilmeResponse cadastrar(FilmeRequest request) {
        return FilmeMapper.toResponse(filmeRepository.save(FilmeMapper.toEntity(request)));
    }
}
