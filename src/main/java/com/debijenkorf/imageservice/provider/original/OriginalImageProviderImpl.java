package com.debijenkorf.imageservice.provider.original;

import com.debijenkorf.imageservice.domain.images.Original;
import com.debijenkorf.imageservice.provider.original.utils.OriginalImageProperties;
import com.debijenkorf.imageservice.provider.utils.NoImageException;
import com.debijenkorf.imageservice.provider.utils.ProviderServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.text.MessageFormat;

@Slf4j
@Service
public class OriginalImageProviderImpl implements OriginalImageProvider {
    private final WebClient webClient;
    private final OriginalImageProperties properties;

    @Autowired
    public OriginalImageProviderImpl(WebClient webClient, OriginalImageProperties properties) {
        this.webClient = webClient;
        this.properties = properties;
    }


    @Override
    public Original getOriginalImage(String firstFourChars, String secondFourChars, String uniqueOriginalImageFileName)
            throws ProviderServerException, NoImageException {
        final String uri = getOriginalImageUrl(firstFourChars, secondFourChars, uniqueOriginalImageFileName);
        Original originalImage;

        try {
            originalImage = webClient.get()
                                     .uri(uri)
                                     .retrieve()
                                     .bodyToMono(Original.class)
                                     .blockOptional()
                                     .orElse(null);
        } catch (WebClientResponseException exception) {
            log.error("Error getting original image from server.");
            throw new ProviderServerException("There was an error with original image provider server.");
        }

        if (originalImage == null) {
            log.info("Image with name {} does not exist.", uniqueOriginalImageFileName);
            throw new NoImageException("Image " + uniqueOriginalImageFileName + " does not exist.");
        }

        return originalImage;
    }

    private String getOriginalImageUrl(String firstFourChars, String secondFourChars, String uniqueOriginalImageFileName) {
        return MessageFormat.format(properties.getUrl(), firstFourChars, secondFourChars, uniqueOriginalImageFileName);
    }
}
