package com.br.artistas.external;

import com.br.artistas.external.model.SpotifyResponse;
import com.br.artistas.security.SpotifyToken;
import reactor.core.publisher.Mono;

public interface SpotifyService {

    Mono<SpotifyResponse> search(String nome);

    Mono<SpotifyToken> getSpotifyToken();

}
