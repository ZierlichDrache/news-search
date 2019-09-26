package com.consdata.solejnik.newssearch.newsapi.exception;

import org.springframework.lang.NonNull;

public class BadRequest extends HttpException {

    public BadRequest(@NonNull final  String message) {
        super(message);
    }
}
