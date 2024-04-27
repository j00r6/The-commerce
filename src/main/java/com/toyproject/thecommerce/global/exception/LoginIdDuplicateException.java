package com.toyproject.thecommerce.global.exception;

import lombok.Getter;

@Getter
public class LoginIdDuplicateException extends RuntimeException{

    public LoginIdDuplicateException(String message) {
        super(message);
    }
}
