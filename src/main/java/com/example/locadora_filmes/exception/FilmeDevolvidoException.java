package com.example.locadora_filmes.exception;

public class FilmeDevolvidoException extends RuntimeException {
    public FilmeDevolvidoException() {
        super("Esse filme já está no estoque!");
    }
}
