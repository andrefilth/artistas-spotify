package com.br.artistas.endpoint.response;

import com.br.artistas.model.Artista;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class ArtistaResponse {

    private final String nome;
    private final List<String> albuns;

    public ArtistaResponse(Artista artista) {
        this.nome = artista.getNome();
        this.albuns = artista.getAlbuns();
//        this.albuns = artista.getAlbuns()
//                .stream()
//                .map(t -> {
//                    if (t instanceof Album) {
//                        return new AlbumResponse((Album) t);
//                    } else {
//                        throw new ArtistaInternalException("Invalid Response: " + t.getClass());
//                    }
//                })
//                .distinct()
//                .collect(toList());

    }

    public String getNome() {
        return nome;
    }

    public List<String> getAlbuns() {
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
