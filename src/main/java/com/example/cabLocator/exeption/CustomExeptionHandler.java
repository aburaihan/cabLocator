package com.example.cabLocator.exeption;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
@RestController
public class CustomExeptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("Handling MethodArgumentNotValidException: {}", ex);
        String errorMessage = "";
        try {
            errorMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        } catch (Exception e) {
            errorMessage = ex.getBindingResult().toString();
        }

        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("status", "faliure");
        errorResponse.put("reason", errorMessage);
        log.error("error : {}", errorMessage);
        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
