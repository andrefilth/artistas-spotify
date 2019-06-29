package com.br.artistas.endpoint.response;

import com.br.artistas.model.Artista;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class ArtistaResponse {

    private final String id;
    private final String nome;
    private final List<String> albuns;

    public ArtistaResponse(Artista artista) {
        this.id = artista.getId();
        this.nome = artista.getNome();
        this.albuns = artista.getAlbuns();

    }

    public String getId() {
        return id;
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
                .append("id", id)
                .append("nome", nome)
                .append("albuns", albuns)
                .build();
    }
}
