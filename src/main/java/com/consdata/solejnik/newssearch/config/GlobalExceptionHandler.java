package com.consdata.solejnik.newssearch.config;

import com.consdata.solejnik.newssearch.externalapi.exception.BadRequest;
import com.consdata.solejnik.newssearch.externalapi.exception.ServerError;
import com.consdata.solejnik.newssearch.externalapi.exception.TooManyRequests;
import com.consdata.solejnik.newssearch.externalapi.exception.Unauthorized;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<String> handleBadRequest(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Unauthorized.class)
    public ResponseEntity<String> handleUnauthorized(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(TooManyRequests.class)
    public ResponseEntity<String> handleTooManyRequests(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.TOO_MANY_REQUESTS);
    }

    @ExceptionHandler(ServerError.class)
    public ResponseEntity<String> handleServerError(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }
}
