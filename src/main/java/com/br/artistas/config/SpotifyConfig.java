package com.br.artistas.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpotifyConfig {

    private static final Logger LOG = LoggerFactory.getLogger(SpotifyConfig.class);

    @Value("${spotify.access.key}")
    private String accessKey;

    @Value("${spotify.secret.key}")
    private String secretKey;

    @Value("${spotify.url.token}")
    private String urlToken;

    @Bean
    public void awsCredentialsProvider() {
        if (accessKey != null) {
            LOG.info("Spotify Configurado!");
        }

    }
}
