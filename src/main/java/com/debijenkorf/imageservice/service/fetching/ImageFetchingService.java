package com.debijenkorf.imageservice.service.fetching;

import com.debijenkorf.imageservice.domain.images.AbstractImageType;
import com.debijenkorf.imageservice.provider.utils.NoImageException;
import com.debijenkorf.imageservice.provider.utils.ProviderServerException;

public interface ImageFetchingService {
    AbstractImageType getOptimizedImage(String predefinedTypeName, String uniqueOriginalImageFilename)
            throws ProviderServerException, NoImageException;

    AbstractImageType getOptimizedImage(String predefinedTypeName, String uniqueOriginalImageFilename, String dummySeoName)
            throws ProviderServerException, NoImageException;
}
