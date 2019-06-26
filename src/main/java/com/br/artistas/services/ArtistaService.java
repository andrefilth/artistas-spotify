package com.br.artistas.services;


import com.br.artistas.model.Artista;
import reactor.core.publisher.Mono;

public interface ArtistaService {

    Mono<Artista> find(String name);
}
