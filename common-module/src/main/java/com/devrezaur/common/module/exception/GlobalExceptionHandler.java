package com.devrezaur.common.module.exception;

import com.devrezaur.common.module.model.CustomHttpResponse;
import com.devrezaur.common.module.util.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomHttpResponse> handleException(Exception ex) {
        String errorMessage = null;
        if (ex.getMessage() != null) {
            errorMessage = ex.getMessage();
        } else if (ex.getCause() != null) {
            errorMessage = ex.getCause().toString();
        }
        return ResponseBuilder.buildFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "500", errorMessage);
    }
}
