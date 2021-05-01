package com.debijenkorf.imageservice.service.fetching;

import com.debijenkorf.imageservice.domain.images.AbstractImageType;

public interface ImageFetchingService {
    AbstractImageType getOptimizedImage(String predefinedTypeName, String uniqueOriginalImageFilename, String dummySeoName);
}
