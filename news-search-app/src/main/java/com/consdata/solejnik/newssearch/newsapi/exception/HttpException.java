package com.consdata.solejnik.newssearch.newsapi.exception;

import org.springframework.lang.NonNull;

public class HttpException extends RuntimeException {

    public HttpException(@NonNull final String message) {
        super(message);
    }
}
