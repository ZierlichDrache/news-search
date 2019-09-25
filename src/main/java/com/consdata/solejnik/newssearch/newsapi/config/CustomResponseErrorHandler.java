package com.consdata.solejnik.newssearch.newsapi.config;

import com.consdata.solejnik.newssearch.exception.JsonParsingException;
import com.consdata.solejnik.newssearch.newsapi.dto.ResponseErrorBody;
import com.consdata.solejnik.newssearch.newsapi.exception.BadRequest;
import com.consdata.solejnik.newssearch.newsapi.exception.ServerError;
import com.consdata.solejnik.newssearch.newsapi.exception.TooManyRequests;
import com.consdata.solejnik.newssearch.newsapi.exception.Unauthorized;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class CustomResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(@NonNull final ClientHttpResponse response) throws IOException {
        return response.getStatusCode().is4xxClientError() ||
                response.getStatusCode().is5xxServerError();
    }

    @Override
    public void handleError(@NonNull final ClientHttpResponse response) throws IOException {

        final String message = extractMessageFromBody(response.getBody());

        if (response.getStatusCode().value() == 400) {
            throw new BadRequest(message);
        }

        if (response.getStatusCode().value() == 401) {
            throw new Unauthorized(message);
        }

        if (response.getStatusCode().value() == 429) {
            throw new TooManyRequests(message);
        }

        if (response.getStatusCode().value() == 500) {
            throw new ServerError(message);
        }

    }

    private String extractMessageFromBody(@NonNull final InputStream body) {
        try {
            final String bodyJson = StreamUtils.copyToString(body, Charset.defaultCharset());
            final ResponseErrorBody responseErrorBody = new ObjectMapper().readValue(bodyJson, ResponseErrorBody.class);
            return responseErrorBody.getMessage();
        } catch (@NonNull final IOException ex) {
            throw new JsonParsingException("An error while parsing error body is occurred.");
        }

    }
}
