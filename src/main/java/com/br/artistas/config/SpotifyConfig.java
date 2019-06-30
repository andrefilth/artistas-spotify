package com.br.artistas.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;

@Configuration
public class SpotifyConfig {

    private static final Logger LOG = LoggerFactory.getLogger(SpotifyConfig.class);

    @Value("${spotify.access.key}")
    private String accessKey;

    @Value("${spotify.secret.key}")
    private String secretKey;

    @Value("${spotify.url.token}")
    private String urlToken;

    @Value("${spotify.url}")
    private String urlApi;

//    @Bean
//    public void awsCredentialsProvider() {
//        if (accessKey != null) {
//            LOG.info("Spotify Configurado! " + urlToken);
//        }
//    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getUrlToken() {
        return urlToken;
    }

    public void setUrlToken(String urlToken) {
        this.urlToken = urlToken;
    }

    public String getUrlApi() {
        return urlApi;
    }

    public void setUrlApi(String urlApi) {
        this.urlApi = urlApi;
    }
}
