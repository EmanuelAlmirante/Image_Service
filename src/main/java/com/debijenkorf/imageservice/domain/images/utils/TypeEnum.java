package com.debijenkorf.imageservice.domain.images.utils;

public enum TypeEnum {
    JPG("JPG"),
    PNG("PNG");

    private final String type;

    TypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
