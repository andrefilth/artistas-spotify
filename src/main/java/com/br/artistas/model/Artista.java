package com.br.artistas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Artista")
public class Artista {

    @Id
    private String id;

    private String nome;

    private List<String> albuns;

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

    public List<String> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(List<String> albuns) {
        this.albuns = albuns;
    }
}
