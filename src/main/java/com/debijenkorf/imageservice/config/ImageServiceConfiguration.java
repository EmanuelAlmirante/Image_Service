package com.debijenkorf.imageservice.config;

import com.debijenkorf.imageservice.provider.optimized.utils.OptimizedImageProperties;
import com.debijenkorf.imageservice.provider.original.utils.OriginalImageProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableConfigurationProperties({OptimizedImageProperties.class, OriginalImageProperties.class})
public class ImageServiceConfiguration {
    private static final Integer MAX_IN_MEMORY_SIZE = 16 * 1024 * 1024;

    @Bean
    public WebClient getWebClientBuilder() {
        return WebClient.builder().exchangeStrategies(ExchangeStrategies.builder()
                                                                        .codecs(configurer -> configurer.defaultCodecs()
                                                                                                        .maxInMemorySize(
                                                                                                                MAX_IN_MEMORY_SIZE))
                                                                        .build())
                        .build();
    }
}
