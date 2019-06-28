package com.br.artistas.endpoint.request;

import com.br.artistas.types.SearchType;

public class ArtistaRequest {

    private String nome;

    private SearchType tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public SearchType getTipo() {
        return tipo;
    }

    public void setTipo(SearchType tipo) {
        this.tipo = tipo;
    }
}
