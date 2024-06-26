package com.toyproject.thecommerce.global.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class Message {
    private String message;
    private HttpStatus status;
}
