package com.debijenkorf.imageservice.provider.optimized;

import com.debijenkorf.imageservice.domain.images.AbstractImageType;
import com.debijenkorf.imageservice.provider.utils.NoImageException;
import com.debijenkorf.imageservice.provider.utils.ProviderServerException;

public interface OptimizedImageProvider {
    AbstractImageType getOptimizedImage(String predefinedTypeName, String firstFourChars, String secondFourChars, String uniqueOriginalImageFileName)
            throws ProviderServerException, NoImageException;
}
