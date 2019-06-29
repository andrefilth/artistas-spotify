package com.br.artistas.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Configuration
public class ArtistaInternalException extends ArtistaException {

    private static final Logger LOG = LoggerFactory.getLogger(ArtistaInternalException.class);

    public ArtistaInternalException(String message) {
        super(INTERNAL_SERVER_ERROR.value(), "Ops... Ocorreu um erro interno.", message);
        LOG.error(message);
    }

    public ArtistaInternalException() {
        super(INTERNAL_SERVER_ERROR.value(), "Ops... Ocorreu um erro interno.", null);
    }

}
