package com.br.artistas.types;

import com.br.artistas.exceptions.ArtistaInvalidInputException;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum SearchType {

    album,artist,playlist,track;

    @JsonCreator
    static SearchType of(String value) {
        try {
            return valueOf(value);
        } catch (Exception e) {
            throw new ArtistaInvalidInputException("spotify_status_parse_error", "Os Types validos sao: "
                    + Arrays.toString(SearchType.values()));
        }
    }
}
