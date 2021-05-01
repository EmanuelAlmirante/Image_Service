package com.debijenkorf.imageservice.domain.images.utils;

public enum ScaleTypeEnum {
    CROP("Crop"),
    FILL("Fill"),
    SKEW("Skew");

    private final String scaleType;

    ScaleTypeEnum(String scaleType) {
        this.scaleType = scaleType;
    }

    public String getScaleType() {
        return scaleType;
    }
}
