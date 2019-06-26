package com.br.artistas.endpoint;


import com.br.artistas.endpoint.response.HealthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.br.artistas.constants.Constants.CONTEXT_PATH;


@RestController
@RequestMapping(CONTEXT_PATH)
public class HealthEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(HealthEndpoint.class);

    @GetMapping("/health")
    public Mono<HealthResponse> health() {
        return Mono.just(new HealthResponse())
                .doOnSuccess(t -> LOG.info("Status da aplicação [{}]", t));
    }

}
