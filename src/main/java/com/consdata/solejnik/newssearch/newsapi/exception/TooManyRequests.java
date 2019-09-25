package com.consdata.solejnik.newssearch.newsapi.exception;

import org.springframework.lang.NonNull;

public class TooManyRequests extends HttpException {

    public TooManyRequests(@NonNull final  String message) {
        super(message);
    }
}
