package com.debijenkorf.imageservice.provider.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProviderServerException extends Exception {
    public ProviderServerException(String message) {
        super(message);
    }
}
