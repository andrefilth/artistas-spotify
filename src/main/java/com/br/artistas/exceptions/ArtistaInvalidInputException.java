package com.br.artistas.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebInputException;

import static org.springframework.http.HttpStatus.*;

public class ArtistaInvalidInputException extends ArtistaException {

    public ArtistaInvalidInputException(ServerWebInputException ex) {
        super(BAD_REQUEST.value(), "Entrada inválida", "Não foi possível parsear a entrada.");
    }

    public ArtistaInvalidInputException(String errorCode, String message) {
        super(BAD_REQUEST.value(), errorCode, message);
    }

}
