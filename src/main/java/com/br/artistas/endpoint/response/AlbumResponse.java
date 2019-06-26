package com.br.artistas.endpoint.response;

import com.br.artistas.model.Album;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AlbumResponse {

    private final String nome;

    public AlbumResponse(Album album) {
        this.nome = album.getNome();
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("nome", nome)
                .build();
    }
}
