package com.debijenkorf.imageservice.controller.utils.images;

import java.util.stream.Stream;

public enum PredefinedImageTypeEnum {
    THUMBNAIL("thumbnail");

    private final String predefinedImageType;

    PredefinedImageTypeEnum(String predefinedImageType) {
        this.predefinedImageType = predefinedImageType;
    }

    public String getPredefinedImageType() {
        return predefinedImageType;
    }

    public static Stream<PredefinedImageTypeEnum> predefinedImageTypeEnumStream() {
        return Stream.of(PredefinedImageTypeEnum.values());
    }
}
