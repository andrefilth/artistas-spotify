package com.br.artistas.services;


import com.br.artistas.model.Artista;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ArtistaService {

    Mono<Artista> findBy(String name);

    Mono<List<Artista>> findAll();
}
