package com.br.artistas.exceptions.serializer;

import com.br.artistas.exceptions.ArtistaException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.reactivestreams.Publisher;

public interface ExceptionParserInterface {

    Publisher<Void> parse(ArtistaException ex) throws JsonProcessingException;

}
