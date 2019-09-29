package com.consdata.solejnik.newssearch.config;

import com.consdata.solejnik.newssearch.exception.JsonParsingException;
import com.consdata.solejnik.newssearch.exception.MissingPageParamsException;
import com.consdata.solejnik.newssearch.newsapi.exception.BadRequest;
import com.consdata.solejnik.newssearch.newsapi.exception.ExternalServerError;
import com.consdata.solejnik.newssearch.newsapi.exception.TooManyRequests;
import com.consdata.solejnik.newssearch.newsapi.exception.Unauthorized;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<String> handleBadRequest(@NonNull final Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Unauthorized.class)
    public ResponseEntity<String> handleUnauthorized(@NonNull final Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(TooManyRequests.class)
    public ResponseEntity<String> handleTooManyRequests(@NonNull final Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.TOO_MANY_REQUESTS);
    }

    @ExceptionHandler(ExternalServerError.class)
    public ResponseEntity<String> handleExternalServerError(@NonNull final Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(JsonParsingException.class)
    public ResponseEntity<String> handleJsonParsingException(@NonNull final Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MissingPageParamsException.class)
    public ResponseEntity<String> handleMissingPageParamsException(@NonNull final Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
