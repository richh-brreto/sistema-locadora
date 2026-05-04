package com.example.locadora_filmes.repository;

import com.example.locadora_filmes.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
    boolean existsByFilmeIdAndDevolvidoFalse(Long id);
}
