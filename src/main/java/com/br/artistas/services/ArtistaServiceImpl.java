package com.br.artistas.services;

import com.br.artistas.endpoint.ArtistaEndpoint;
import com.br.artistas.external.SpotifyService;
import com.br.artistas.external.model.SpotifyResponse;
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

    private final SpotifyService spotifyService;

    @Autowired
    public ArtistaServiceImpl(ArtistaRepository repository, SpotifyService spotifyService) {
        this.repository = repository;
        this.spotifyService = spotifyService;
    }

    @Override
    public Optional<Artista> findByNomeStartingWith(String name) {
        return getByNomeStartingWith(name);

    }


    @Override
    public Mono<Artista> findBy(String name) {
        Optional<Artista> artista = getByNomeStartingWith(name);
        if(artista.isPresent()){
            return Mono.justOrEmpty(artista);
        }else{
            Mono<SpotifyResponse> search = spotifyService.search(name);
                  search.doOnSuccess(c-> LOG.info("Dados de retorno: [ {} ]", c.getArtists()));
            return Mono.empty();
        }

    }

    @Override
    public Mono<List<Artista>> findAll() {
        List<Artista> artistas = repository.findAll();
        return Mono.justOrEmpty(artistas);
    }

    @Override
    public Mono<Artista> update(Artista artista) {
        Artista save = repository.save(artista);
        return Mono.justOrEmpty(save);
    }

    @Override
    public Mono<Void> delete(Artista artista) {
        repository.delete(artista);
        return Mono.empty();
    }

    @Override
    public Mono<Artista> create(Artista artista) {
        Artista save = repository.save(artista);
        return Mono.justOrEmpty(save);
    }

    @Override
    public Mono<Artista> findByUuid(String uuid) {
        Optional<Artista> artista = repository.findById(uuid);
        return Mono.justOrEmpty(artista.get());
    }

    @Override
    public Mono<SpotifyResponse> token(String nome) {
        return spotifyService.search(nome);
    }


    private Optional<Artista> getByNomeStartingWith(String name) {
        return repository.findByNomeStartingWith(name).stream().findAny();
    }

}
