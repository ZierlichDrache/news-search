package com.consdata.solejnik.newssearch.exception;

import org.springframework.lang.NonNull;

public class MissingPageParamsException extends  RuntimeException {

    public MissingPageParamsException(@NonNull final String message) {
        super(message);
    }
}
