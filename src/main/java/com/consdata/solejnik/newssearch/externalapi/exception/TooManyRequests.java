package com.consdata.solejnik.newssearch.externalapi.exception;

public class TooManyRequests extends RuntimeException {

    public TooManyRequests(final String message) {
        super(message);
    }
}
