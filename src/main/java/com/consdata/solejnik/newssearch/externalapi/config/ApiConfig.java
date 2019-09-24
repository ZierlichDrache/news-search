package com.consdata.solejnik.newssearch.externalapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class ApiConfig {

    @Value("${externalApiKey}")
    private String externalApiKey;

    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ApiResponseErrorHandler());
        restTemplate.setInterceptors(Collections.singletonList(new ApiHeaderInterceptor(externalApiKey)));
        return restTemplate;
    }
}
