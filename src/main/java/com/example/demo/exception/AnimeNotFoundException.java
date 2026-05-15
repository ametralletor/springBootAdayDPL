package com.example.demo.exception;

public class AnimeNotFoundException extends RuntimeException {

    public AnimeNotFoundException(Long id) {
        super("No se encontró el anime con ID: " + id);
    }
}