package com.br.artistas.exceptions;


import static org.springframework.http.HttpStatus.FOUND;

public class ArtistaFoundException extends ArtistaException {

    public ArtistaFoundException() {
        super(FOUND.value(), "resource_not_found", "Não foi possível encontrar o recurso");
    }

    public ArtistaFoundException(String errorCode, String message) {
        super(FOUND.value(), errorCode, message);
    }
}
