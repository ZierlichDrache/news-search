package com.consdata.solejnik.newssearch.newsapi.exception;

import org.springframework.lang.NonNull;

public class ServerError extends HttpException {

    public ServerError(@NonNull final  String message) {
        super(message);
    }
}
