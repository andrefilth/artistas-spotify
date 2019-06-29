package com.br.artistas.services;

import com.br.artistas.endpoint.ArtistaEndpoint;
import com.br.artistas.model.Artista;
import com.br.artistas.repositories.ArtistaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaServiceImpl implements ArtistaService {

    private static final Logger LOG = LoggerFactory.getLogger(ArtistaEndpoint.class);

    private final ArtistaRepository repository;

    @Autowired
    public ArtistaServiceImpl(ArtistaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Artista> findByNomeStartingWith(String name) {
        return getByNomeStartingWith(name);

    }

    @Override
    public Mono<Artista> findBy(String name) {
        return Mono.justOrEmpty(getByNomeStartingWith(name).get());
    }

    private Optional<Artista> getByNomeStartingWith(String name) {
        return repository.findByNomeStartingWith(name).stream().findAny();
    }

    @Override
    public Mono<List<Artista>> findAll() {
        List<Artista> artistas = repository.findAll();
        return Mono.justOrEmpty(artistas);
    }

    @Override
    public Mono<Artista> create(Artista artista) {
        Artista save = repository.save(artista);
        return Mono.justOrEmpty(save);
    }

}
