package com.br.artistas.endpoint;

import com.br.artistas.endpoint.request.ArtistaRequest;
import com.br.artistas.endpoint.response.ArtistaResponse;
import com.br.artistas.endpoint.utils.ArtistaUtils;
import com.br.artistas.exceptions.ArtistaFoundException;
import com.br.artistas.exceptions.ArtistaNotFoundException;
import com.br.artistas.external.model.SpotifyResponse;
import com.br.artistas.model.Artista;
import com.br.artistas.services.ArtistaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static com.br.artistas.constants.Constants.CONTEXT_PATH;
import static com.br.artistas.endpoint.utils.ArtistaUtils.toModel;

@RestController
@RequestMapping(CONTEXT_PATH)
public class ArtistaEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(ArtistaEndpoint.class);

    private final ArtistaService service;

    @Autowired
    public ArtistaEndpoint(ArtistaService service) {
        this.service = service;
    }

    @ResponseStatus(value = HttpStatus.FOUND)
    @GetMapping("/spotify")
    public Mono<SpotifyResponse> token(@RequestParam(value = "nome") String nome) {

        LOG.info("Buscando nome: [ {} ]");

        return service.token(nome)
//                .switchIfEmpty(Mono.error(new ArtistaNotFoundException("artistas_validation",	"Informações não encontradas para o nome  " + nome)))
//                .map(ArtistaResponse::new)
                .doOnSuccess(wr -> LOG.info("Coleção completa do artista [ {} ]", wr));
    }

    @ResponseStatus(value = HttpStatus.FOUND)
    @GetMapping("/artista")
    public Mono<ArtistaResponse> find(@RequestParam(value = "nome") String nome) {

        LOG.info("Buscando o artista NOME: [ {} ]", nome);

        return service.findBy(nome)
                .switchIfEmpty(Mono.error(new ArtistaNotFoundException("artistas_validation",	"Informações não encontradas para o nome  " + nome)))
                .map(ArtistaResponse::new)
                .doOnSuccess(wr -> LOG.info("Coleção completa do artista [ {} ]", wr));
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/artista")
    public Mono<Void> create(@RequestBody ArtistaRequest request) {

        LOG.info("Inserindo dados de novos artistas [{}]", request);

        return existe(request.getNome())
                .flatMap(artista -> service.create(toModel(request)))
                .map(ArtistaResponse::new)
                .doOnSuccess(wr -> LOG.info("Artista gravado com sucesso [{}]", wr)).then();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/artista/{uuid}")
    public Mono<ArtistaResponse> update(@PathVariable("uuid") String uuid,@RequestBody ArtistaRequest request) {

        LOG.info("Alterando informações do artista UUID: [ {} ]", uuid);

        return service.findByUuid(uuid)
                .switchIfEmpty(Mono.error(new ArtistaNotFoundException("artistas_validation",	"Informações não encontradas para o nome  " + request.getNome())))
                .map(model-> ArtistaUtils.toUpdate(model,request))
                .flatMap(newArtista -> service.update(newArtista))
                .map(ArtistaResponse::new)
                .doOnSuccess(wr -> LOG.info("Alteração realizada com sucesso [ {} ]", wr));
    }
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("/artista/{uuid}")
    public Mono<Void> delete(@PathVariable("uuid") String uuid) {

        LOG.info("Alterando informações do artista UUID: [ {} ]", uuid);

        return service.findByUuid(uuid)
                .switchIfEmpty(Mono.error(new ArtistaNotFoundException("artistas_validation",	"Informações não encontradas para o nome  " + uuid)))
                .flatMap(newArtista -> service.delete(newArtista))
                .doOnSuccess(wr -> LOG.info("Artista deletado com sucesso [ {} ]", wr));
    }

    private Mono<Artista> existe(String nome) {
        Optional<Artista> artista = service.findByNomeStartingWith(nome);
        if(artista.stream().count() > 0){
            return Mono.error(new ArtistaFoundException("artistas_validation",	"Já existe um artista cadastrado " ));
        }
        return Mono.justOrEmpty(artista.get());
    }
//        return service.findBy(nome).map(c->{
//            if(c.getNome().endsWith(nome)){
//                return Mono.error(new ArtistaFoundException("artistas_validation",	"Já existe um artista cadastrado " ));
//            }
////            return Mono.justOrEmpty(c);
//        }).map(Artista::);
//    }
//
//    @ResponseStatus(value = HttpStatus.OK)
//    @GetMapping("/artista")
//    public Mono<List<ArtistaResponse>> findAll() {
//
//        LOG.info("Buscando todos os artistas: [ {} ]");
//
//        return service.findAll()
//                .switchIfEmpty(Mono.error(new ArtistaNotFoundException("artistas_validation",	"Informações não encontradas " )))
//                .map(ArtistaUtils::toResponse)
//                .doOnSuccess(wr -> LOG.info("Coleção completa do artista [ {} ]", wr));
//    }
}
