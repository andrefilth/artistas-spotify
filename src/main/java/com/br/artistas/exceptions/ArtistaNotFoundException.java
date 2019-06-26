package com.br.artistas.exceptions;


import static org.springframework.http.HttpStatus.NOT_FOUND;

public class ArtistaNotFoundException extends ArtistaException {

    public ArtistaNotFoundException() {
        super(NOT_FOUND.value(), "resource_not_found", "Não foi possível encontrar o recurso");
    }

    public ArtistaNotFoundException(String errorCode, String message) {
        super(NOT_FOUND.value(), errorCode, message);
    }
}
