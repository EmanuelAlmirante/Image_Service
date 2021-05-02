package com.debijenkorf.imageservice.provider.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoImageException extends Exception {
    public NoImageException(String message) {
        super(message);
    }
}
