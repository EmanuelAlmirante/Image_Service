package com.debijenkorf.imageservice.provider.optimized;

import com.debijenkorf.imageservice.domain.images.AbstractImageType;
import com.debijenkorf.imageservice.provider.optimized.utils.OptimizedImageProperties;
import com.debijenkorf.imageservice.provider.utils.NoImageException;
import com.debijenkorf.imageservice.provider.utils.ProviderServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.text.MessageFormat;

@Slf4j
@Service
public class OptimizedImageProviderImpl implements OptimizedImageProvider {
    @Value("${aws.aws_s3_endpoint}")
    private String awsEndpoint;

    private final WebClient webClient;
    private final OptimizedImageProperties properties;

    @Autowired
    public OptimizedImageProviderImpl(WebClient webClient, OptimizedImageProperties properties) {
        this.webClient = webClient;
        this.properties = properties;
    }

    @Override
    public AbstractImageType getOptimizedImage(String predefinedTypeName, String firstFourChars, String secondFourChars, String uniqueOriginalImageFileName)
            throws ProviderServerException, NoImageException {
        final String uri = getOptimizedImageUrl(awsEndpoint, predefinedTypeName, firstFourChars, secondFourChars,
                                                uniqueOriginalImageFileName);
        AbstractImageType abstractImageType;

        try {
            abstractImageType = webClient.get()
                                         .uri(uri)
                                         .retrieve()
                                         .bodyToMono(AbstractImageType.class).blockOptional()
                                         .orElse(null);
        } catch (WebClientResponseException exception) {
            log.error("Error getting original image from server.");
            throw new ProviderServerException("There was an error with original image provider server.");
        }

        if (abstractImageType == null) {
            log.info("Image with name {} does not exist.", uniqueOriginalImageFileName);
            throw new NoImageException("Image " + uniqueOriginalImageFileName + " does not exist.");
        }

        return abstractImageType;
    }

    private String getOptimizedImageUrl(String awsEndpoint, String predefinedTypeName, String firstFourChars, String secondFourChars, String uniqueOriginalImageFileName) {
        return MessageFormat
                .format(awsEndpoint + properties.getUrl(), predefinedTypeName, firstFourChars, secondFourChars,
                        uniqueOriginalImageFileName);
    }
}
