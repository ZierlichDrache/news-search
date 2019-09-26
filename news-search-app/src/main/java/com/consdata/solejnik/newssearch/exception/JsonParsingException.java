package com.consdata.solejnik.newssearch.exception;

import org.springframework.lang.NonNull;

public class JsonParsingException extends RuntimeException {

    public JsonParsingException(@NonNull final String message) {
        super(message);
    }
}
