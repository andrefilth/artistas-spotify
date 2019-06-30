package com.br.artistas.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(collection = "Artista")
public class Artista {

    @Id
    private String id;

    private String nome;

    private Set<String> albuns;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<String> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(Set<String> albuns) {
        this.albuns = albuns;
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
