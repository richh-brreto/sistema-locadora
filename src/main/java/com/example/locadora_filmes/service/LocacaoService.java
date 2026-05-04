package com.example.locadora_filmes.service;
import com.example.locadora_filmes.DTO.locacao.LocacaoRequest;
import com.example.locadora_filmes.exception.FilmeAlugadoException;
import com.example.locadora_filmes.exception.FilmeDevolvidoException;
import com.example.locadora_filmes.model.Cliente;
import com.example.locadora_filmes.model.Filme;
import com.example.locadora_filmes.model.Locacao;
import com.example.locadora_filmes.repository.ClienteRepository;
import com.example.locadora_filmes.repository.FilmeRepository;
import com.example.locadora_filmes.repository.LocacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class LocacaoService {
    private final LocacaoRepository locacaoRepository;
    private final ClienteRepository clienteRepository;
    private final FilmeRepository filmeRepository;

    public LocacaoService(LocacaoRepository locacaoRepository, ClienteRepository clienteRepository, FilmeRepository filmeRepository) {
        this.locacaoRepository = locacaoRepository;
        this.clienteRepository = clienteRepository;
        this.filmeRepository = filmeRepository;
    }

    public List<Locacao> listar(){
        return locacaoRepository.findAll();
    }

    public Locacao registrarLocacao(@RequestBody LocacaoRequest request){
        Cliente cliente = clienteRepository.findById(request.clienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        Filme filme = filmeRepository.findById(request.filmeId())
                .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado"));

        if (locacaoRepository.existsByFilmeIdAndDevolvidoFalse(filme.getId())) {
            throw new FilmeAlugadoException();
        }

        Locacao response = new Locacao();
        response.setCliente(cliente);
        response.setFilme(filme);
        response.setDataLocacao(LocalDate.now());
        response.setDevolvido(false);

        return locacaoRepository.save(response);
    }

    public Locacao devolver (Long id){
        Locacao locacao = locacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Locação não encontrada"));

        if(locacao.isDevolvido()){
            throw new FilmeDevolvidoException();
        }

        locacao.setDevolvido(true);
        locacao.setDataDevolucao(LocalDate.now());
        return locacaoRepository.save(locacao);
    }
}
