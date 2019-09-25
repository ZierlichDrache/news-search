package com.consdata.solejnik.newssearch.newsapi.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.NonNull;

import java.io.IOException;

public class HeaderInterceptor implements ClientHttpRequestInterceptor {

    private String externalApiKey;

    public HeaderInterceptor(@NonNull final  String externalApiKey) {
        this.externalApiKey = externalApiKey;
    }

    @Override
    public ClientHttpResponse intercept(@NonNull final  HttpRequest request,
                                        @NonNull final  byte[] body,
                                        @NonNull final  ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
        headers.add("X-Api-Key", externalApiKey);
        return execution.execute(request, body);
    }
}
