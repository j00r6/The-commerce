package com.toyproject.thecommerce.global.exception;

import lombok.Getter;

@Getter
public class exampleException extends RuntimeException{

    public exampleException(String message) {
        super(message);
    }
}
