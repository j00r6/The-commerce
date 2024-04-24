package com.toyproject.thecommerce.global.handler;

import com.toyproject.thecommerce.global.exception.exampleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(exampleException.class)
    public ResponseEntity<Message> handle(exampleException e) {
        Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}