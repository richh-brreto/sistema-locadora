package com.example.locadora_filmes.exception;

public class FilmeAlugadoException extends RuntimeException {
    public FilmeAlugadoException() {
        super("Filme ja alugado!");
    }
}
