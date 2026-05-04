package com.example.locadora_filmes.DTO.locacao;

import java.time.LocalDate;

public record LocacaoResponse(String nome, String titulo, LocalDate dataAlugado, LocalDate dataDevolvido) {
}
