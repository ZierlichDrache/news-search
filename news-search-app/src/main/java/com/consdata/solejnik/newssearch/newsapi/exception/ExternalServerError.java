package com.consdata.solejnik.newssearch.newsapi.exception;

import org.springframework.lang.NonNull;

public class ExternalServerError extends HttpException {

    public ExternalServerError(@NonNull final  String message) {
        super(message);
    }
}
