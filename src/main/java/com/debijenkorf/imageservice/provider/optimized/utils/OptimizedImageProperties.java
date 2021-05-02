package com.debijenkorf.imageservice.provider.optimized.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties("optimized-image")
public class OptimizedImageProperties {
    private String url;
}
