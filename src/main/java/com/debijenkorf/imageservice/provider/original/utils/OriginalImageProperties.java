package com.debijenkorf.imageservice.provider.original.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties("original-image")
public class OriginalImageProperties {
    private String url;
}
