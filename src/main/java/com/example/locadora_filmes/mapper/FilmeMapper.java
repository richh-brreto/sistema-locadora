package com.example.locadora_filmes.mapper;

import com.example.locadora_filmes.DTO.filme.FilmeRequest;
import com.example.locadora_filmes.DTO.filme.FilmeResponse;
import com.example.locadora_filmes.model.Filme;

public class FilmeMapper {
    public static FilmeResponse toResponse(Filme filme){
        FilmeResponse response = new FilmeResponse(
                filme.getId(), filme.getTitulo(), filme.getGenero(), filme.getDiretor()
        );

        return response;
    }

    public static Filme toEntity(FilmeRequest request){
        Filme filme = new Filme();
        filme.setDiretor(request.diretor());
        filme.setGenero(request.genero());
        filme.setTitulo(request.titulo());

        return filme;
    }
}
