package com.br.artistas.services;


import com.br.artistas.model.Artista;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface ArtistaService {

    Optional<Artista> findByNomeStartingWith(String name);

    Mono<Artista> findBy(String name);

    Mono<List<Artista>> findAll();

    Mono<Artista> create(Artista request);

    Mono<Artista> findByUuid(String uuid);
}
