package com.example.locadora_filmes.repository;

import com.example.locadora_filmes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
