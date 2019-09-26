package com.consdata.solejnik.newssearch.newsapi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.NonNull;

import java.io.IOException;

public class HeaderInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(HeaderInterceptor.class);

    private String externalApiKey;

    public HeaderInterceptor(@NonNull final String externalApiKey) {
        this.externalApiKey = externalApiKey;
    }

    @Override
    public ClientHttpResponse intercept(@NonNull final HttpRequest request,
                                        @NonNull final byte[] body,
                                        @NonNull final ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
        headers.add("X-Api-Key", externalApiKey);

        logRequestDetails(request);

        return execution.execute(request, body);
    }

    private void logRequestDetails(HttpRequest request) {
        LOGGER.info("Request Headers: {}", request.getHeaders());
        LOGGER.info("Request Method: {}", request.getMethod());
        LOGGER.info("Request URI: {}", request.getURI());
    }
}
