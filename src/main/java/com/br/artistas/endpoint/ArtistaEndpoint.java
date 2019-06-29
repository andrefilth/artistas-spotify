package com.br.artistas.endpoint;

import com.br.artistas.endpoint.request.ArtistaRequest;
import com.br.artistas.endpoint.response.ArtistaResponse;
import com.br.artistas.exceptions.ArtistaFoundException;
import com.br.artistas.exceptions.ArtistaNotFoundException;
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

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/artista")
    public Mono<ArtistaResponse> find(@RequestBody ArtistaRequest request) {

        LOG.info("Buscando o artista NOME: [ {} ]", request.getNome());

        return service.findBy(request.getNome())
                .switchIfEmpty(Mono.error(new ArtistaNotFoundException("artistas_validation",	"Informações não encontradas para o nome  " + request.getNome())))
                .map(ArtistaResponse::new)
                .doOnSuccess(wr -> LOG.info("Coleção completa do artista [ {} ]", wr));
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/artista")
    public Mono<Void> create(@RequestBody ArtistaRequest request) {

        LOG.info("Inserindo dados de novos artistas [{}]", request);

        return existeArtista(request.getNome())
                .flatMap(artista -> service.create(toModel(request)))
                .map(ArtistaResponse::new)
                .doOnSuccess(wr -> LOG.info("Artista gravado com sucesso [{}]", wr)).then();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/artista/{uuid}")
    public Mono<ArtistaResponse> update(@PathVariable("uuid") String uuid,@RequestBody ArtistaRequest request) {

        LOG.info("Alterando informações do artista NOME: [ {} ]", request.getNome());

        return service.findByUuid(uuid)
                .switchIfEmpty(Mono.error(new ArtistaNotFoundException("artistas_validation",	"Informações não encontradas para o nome  " + request.getNome())))
                .map(ArtistaResponse::new)
                .doOnSuccess(wr -> LOG.info("Coleção completa do artista [ {} ]", wr));
    }

    private Mono<Artista> existeArtista(String nome) {
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
