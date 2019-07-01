package com.br.artistas.external;

import com.br.artistas.external.model.ArtistAlbumSpotifyResponse;
import com.br.artistas.external.model.ArtistSpotifyResponse;
import com.br.artistas.security.SpotifyToken;
import reactor.core.publisher.Mono;

public interface SpotifyService {

    Mono<ArtistAlbumSpotifyResponse> search(String nome);

//    Mono<SpotifyToken> getSpotifyToken();
//
//    Mono<ArtistSpotifyResponse> findArtists(String id);
}
