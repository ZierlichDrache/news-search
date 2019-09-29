package com.consdata.solejnik.newssearch.newsapi.exception;

import org.springframework.lang.NonNull;

public class Unauthorized extends HttpException {

    public Unauthorized(@NonNull final  String message) {
        super(message);
    }
}
