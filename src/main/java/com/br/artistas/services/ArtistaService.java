package com.br.artistas.services;


import com.br.artistas.external.model.Item;
import com.br.artistas.model.Artista;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface ArtistaService {

    Optional<Artista> findByNomeStartingWith(String name);

    Mono<Artista> findBy(String name);

    Mono<List<Artista>> findAll();

    Mono<Artista> update(Artista artista);

    Mono<Void> delete(Artista artista);

    Mono<Artista> create(Artista request);

    Mono<Artista> findByUuid(String uuid);

    Mono<List<Item>> findArtistSpotify(String nome);
}
