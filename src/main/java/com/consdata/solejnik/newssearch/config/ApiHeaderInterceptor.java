package com.consdata.solejnik.newssearch.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class ApiHeaderInterceptor implements ClientHttpRequestInterceptor {

    private String externalApiKey;

    public ApiHeaderInterceptor(final String externalApiKey) {
        this.externalApiKey = externalApiKey;
    }

    @Override
    public ClientHttpResponse intercept(final HttpRequest request,
                                        final byte[] body,
                                        final ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
        headers.add("X-Api-Key", externalApiKey);
        return execution.execute(request, body);
    }
}
