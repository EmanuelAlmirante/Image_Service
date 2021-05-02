package com.debijenkorf.imageservice.provider.original;

import com.debijenkorf.imageservice.domain.images.Original;
import com.debijenkorf.imageservice.provider.utils.NoImageException;
import com.debijenkorf.imageservice.provider.utils.ProviderServerException;

public interface OriginalImageProvider {
    Original getOriginalImage(String firstFourChars, String secondFourChars, String uniqueOriginalImageFileName)
            throws ProviderServerException, NoImageException;
}
