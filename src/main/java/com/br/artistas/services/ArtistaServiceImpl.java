package com.br.artistas.services;

import com.br.artistas.endpoint.ArtistaEndpoint;
import com.br.artistas.model.Artista;
import com.br.artistas.repositories.ArtistaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.List;

import static java.util.UUID.randomUUID;

@Service
public class ArtistaServiceImpl implements ArtistaService {

    private static final Logger LOG = LoggerFactory.getLogger(ArtistaEndpoint.class);

    private final ArtistaRepository repository;

    @Autowired
    public ArtistaServiceImpl(ArtistaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Artista> find(String name) {
        return null;
    }

    @Override
    public Mono<List<Artista>> findAll() {
        List<Artista> artistas = repository.findAll();
        return Mono.justOrEmpty(artistas);
    }

    @PostConstruct
    public void Init() {

        Artista sidney = new Artista();
        sidney.setId(randomUUID().toString());
        sidney.setNome("Sidney Magal");
        sidney.setAlbuns(List.of("Baila Magal", "Coração Latino", "Vibrações"));
        repository.save(sidney);

//        repository.save(fernando);
    }
}
