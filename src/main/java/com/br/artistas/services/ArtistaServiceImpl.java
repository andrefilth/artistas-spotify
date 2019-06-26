package com.br.artistas.services;

import com.br.artistas.endpoint.ArtistaEndpoint;
import com.br.artistas.model.Artista;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ArtistaServiceImpl implements ArtistaService {

    private static final Logger LOG = LoggerFactory.getLogger(ArtistaEndpoint.class);

    @Override
    public Mono<Artista> find(String name) {
        return null;
    }
}
