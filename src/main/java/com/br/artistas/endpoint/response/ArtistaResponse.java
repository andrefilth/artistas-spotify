package com.br.artistas.endpoint.response;

import com.br.artistas.model.Album;
import com.br.artistas.exceptions.ArtistaInternalException;
import com.br.artistas.model.Artista;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ArtistaResponse {

    private final String nome;
    private final List<AlbumResponse> albuns;

    public ArtistaResponse(Artista artista) {
        this.nome = artista.getNome();
        this.albuns = artista.getAlbuns()
                .stream()
                .map(t -> {
                    if (t instanceof Album) {
                        return new AlbumResponse((Album) t);
                    } else {
                        throw new ArtistaInternalException("Invalid Response: " + t.getClass());
                    }
                })
                .distinct()
                .collect(toList());

    }

    public String getNome() {
        return nome;
    }

    public List<AlbumResponse> getAlbuns() {
        return albuns;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("nome", nome)
                .append("albuns", albuns)
                .build();
    }
}
