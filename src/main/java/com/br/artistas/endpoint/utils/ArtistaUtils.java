package com.br.artistas.endpoint.utils;

import com.br.artistas.endpoint.request.ArtistaRequest;
import com.br.artistas.endpoint.response.ArtistaResponse;
import com.br.artistas.exceptions.ArtistaInternalException;
import com.br.artistas.model.Artista;

import java.util.List;

import static java.util.UUID.randomUUID;
import static java.util.stream.Collectors.toList;

public class ArtistaUtils {

    public static List<ArtistaResponse> toResponse(List<Artista> artistas) {
       return artistas.stream()
                .map(t -> {
                    if (t instanceof Artista) {
                        return new ArtistaResponse((Artista) t);
                    } else {
                        throw new ArtistaInternalException("Invalid Response: " + t.getClass());
                    }
                })
                .distinct()
                .collect(toList());

    }

    public static Artista toModel(ArtistaRequest request) {
        Artista artista = new Artista();
        artista.setId(randomUUID().toString());
        artista.setNome(request.getNome());
        artista.setAlbuns(request.getAlbuns());
        return artista;

    }

    public static Artista toUpdate(Artista model, ArtistaRequest request) {
        if(request.getNome()!= null){
            model.setNome(request.getNome());
        }
        if(request.getAlbuns().size()>0){
            model.getAlbuns().addAll(request.getAlbuns());
        }
        return model;

    }
}
