package com.debijenkorf.imageservice.controller.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoPredefinedImageTypeException extends Exception {
    public NoPredefinedImageTypeException(String errorMessage) {
        super(errorMessage);
    }
}
