package com.br.artistas.repositories;

import com.br.artistas.model.Artista;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistaRepository extends MongoRepository<Artista,String> {

   List<Artista> findByNomeStartingWith(String nome);
}
