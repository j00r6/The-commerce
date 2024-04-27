package com.toyproject.thecommerce.global.handler;

import com.toyproject.thecommerce.global.exception.BadRequestException;
import com.toyproject.thecommerce.global.exception.LoginIdDuplicateException;
import com.toyproject.thecommerce.global.exception.NickNameDuplicateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoginIdDuplicateException.class)
    public ResponseEntity<Message> handle(LoginIdDuplicateException e) {
        Message message = new Message(e.getMessage(), HttpStatus.CONFLICT);
        return new ResponseEntity<>(message, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(NickNameDuplicateException.class)
    public ResponseEntity<Message> handle(NickNameDuplicateException e) {
        Message message = new Message(e.getMessage(), HttpStatus.CONFLICT);
        return new ResponseEntity<>(message, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Message> handle(BadRequestException e) {
        Message message = new Message(e.getMessage(), HttpStatus.CONFLICT);
        return new ResponseEntity<>(message, HttpStatus.CONFLICT);
    }
}