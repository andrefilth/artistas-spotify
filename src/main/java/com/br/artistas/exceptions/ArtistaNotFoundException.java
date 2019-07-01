package com.br.artistas.exceptions;


import static org.springframework.http.HttpStatus.NOT_FOUND;

public class ArtistaNotFoundException extends ArtistaException {

    public ArtistaNotFoundException() {
        super(404, "resource_not_found", "Não foi possível encontrar o recurso");
    }

    public ArtistaNotFoundException(String errorCode, String message) {
        super(404, errorCode, message);
    }
}
