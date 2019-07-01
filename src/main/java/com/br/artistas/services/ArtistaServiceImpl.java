package com.br.artistas.services;

import com.br.artistas.endpoint.ArtistaEndpoint;
import com.br.artistas.endpoint.utils.ArtistaUtils;
import com.br.artistas.external.SpotifyService;
import com.br.artistas.external.model.Albums;
import com.br.artistas.external.model.ArtistAlbumSpotifyResponse;
import com.br.artistas.external.model.Item;
import com.br.artistas.model.Artista;
import com.br.artistas.repositories.ArtistaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

import static com.br.artistas.endpoint.utils.ArtistaUtils.*;

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
        }
        LOG.info("Artista não está na base de dados, buscando informações nos serviços do Spotify");
        return spotifyService.search(name)
                .map(ArtistAlbumSpotifyResponse::getAlbums)
                .map(Albums::getItems)
                .map(request -> toResponse(name, request))
                .doOnSuccess( c -> LOG.info("Coleção do artista encontrada: [ {} ] ", c));
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
    public Mono<List<Item>> findArtistSpotify(String nome) {
        return spotifyService.search(nome)
                .map(ArtistAlbumSpotifyResponse::getAlbums)
                .map(Albums::getItems)
//                .flatMap( c-> buscarAlbuns(c))
//                .map(Artist::getItems)
                //.flatMap(itens -> verificaNome(itens, nome))
              //  .flatMap(id -> spotifyService.findArtists(id))
                .doOnSuccess( c -> LOG.info("Coleção do artista encontrada: [ {} ] ", c));
    }

    private Mono<String> verificaNome(List<Item> itens, String nome) {
        Optional<Item> existeArtista = itens.stream().filter(c -> c.getName().equals(nome)).findFirst();
        if (existeArtista.isPresent()){
            return Mono.justOrEmpty(existeArtista.get().getId());
        }else{
            return Mono.empty();
        }
    }


    private Optional<Artista> getByNomeStartingWith(String name) {
        return repository.findByNomeStartingWith(name).stream().findAny();
    }

}
