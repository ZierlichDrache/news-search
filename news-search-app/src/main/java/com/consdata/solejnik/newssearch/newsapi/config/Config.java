package com.consdata.solejnik.newssearch.newsapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class Config {

    @Value("${externalApiKey}")
    private String externalApiKey;

    @Bean
    public RestTemplate getRestTemplate() {
        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new CustomResponseErrorHandler());
        restTemplate.setInterceptors(Collections.singletonList(new HeaderInterceptor(externalApiKey)));
        return restTemplate;
    }
}
