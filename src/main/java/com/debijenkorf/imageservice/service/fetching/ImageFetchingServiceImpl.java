package com.debijenkorf.imageservice.service.fetching;

import com.debijenkorf.imageservice.domain.images.AbstractImageType;
import com.debijenkorf.imageservice.provider.optimized.OptimizedImageProvider;
import com.debijenkorf.imageservice.provider.original.OriginalImageProvider;
import com.debijenkorf.imageservice.provider.utils.NoImageException;
import com.debijenkorf.imageservice.provider.utils.ProviderServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageFetchingServiceImpl implements ImageFetchingService {
    private final OptimizedImageProvider optimizedImageProvider;
    private OriginalImageProvider originalImageProvider;

    @Autowired
    public ImageFetchingServiceImpl(OptimizedImageProvider optimizedImageProvider, OriginalImageProvider originalImageProvider) {
        this.optimizedImageProvider = optimizedImageProvider;
        this.originalImageProvider = originalImageProvider;
    }

    @Override
    public AbstractImageType getOptimizedImage(String predefinedTypeName, String uniqueOriginalImageFilename)
            throws ProviderServerException, NoImageException {
        String firstFourChars = parseFirstFourChars(uniqueOriginalImageFilename);
        String secondFourChars = parseSecondFourChars(uniqueOriginalImageFilename);
        String parsedUniqueOriginalImageFilename = parseUniqueOriginalImageFilename(uniqueOriginalImageFilename);

        optimizedImageProvider.getOptimizedImage(predefinedTypeName,
                                                 firstFourChars,
                                                 secondFourChars,
                                                 parsedUniqueOriginalImageFilename);

        return null;
    }

    @Override
    public AbstractImageType getOptimizedImage(String predefinedTypeName, String uniqueOriginalImageFilename, String dummySeoName)
            throws ProviderServerException, NoImageException {
        String firstFourChars = parseFirstFourChars(uniqueOriginalImageFilename);
        String secondFourChars = parseSecondFourChars(uniqueOriginalImageFilename);
        String parsedUniqueOriginalImageFilename = parseUniqueOriginalImageFilename(uniqueOriginalImageFilename);

        optimizedImageProvider.getOptimizedImage(predefinedTypeName,
                                                 firstFourChars,
                                                 secondFourChars,
                                                 parsedUniqueOriginalImageFilename);

        return null;
    }

    private String parseFirstFourChars(String uniqueOriginalImageFilename) {
        if (uniqueOriginalImageFilename.length() >= 4) {
            return uniqueOriginalImageFilename.substring(0, 4);
        }

        return uniqueOriginalImageFilename;
    }

    private String parseSecondFourChars(String uniqueOriginalImageFilename) {
        if (uniqueOriginalImageFilename.length() > 4 && uniqueOriginalImageFilename.length() < 8) {
            return null;
        }

        return uniqueOriginalImageFilename.substring(5, 8);
    }

    private String parseUniqueOriginalImageFilename(String uniqueOriginalImageFilename) {
        return uniqueOriginalImageFilename.replace("/", "_");
    }
}
