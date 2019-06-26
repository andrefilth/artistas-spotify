package com.br.artistas.endpoint.utils;

import com.br.artistas.endpoint.response.ArtistaResponse;
import com.br.artistas.exceptions.ArtistaInternalException;
import com.br.artistas.model.Artista;

import java.util.List;

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

}
