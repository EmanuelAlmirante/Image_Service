package com.debijenkorf.imageservice.service.fetching;

import com.debijenkorf.imageservice.domain.images.AbstractImageType;
import com.debijenkorf.imageservice.domain.images.Thumbnail;
import com.debijenkorf.imageservice.domain.images.utils.ScaleTypeEnum;
import com.debijenkorf.imageservice.domain.images.utils.TypeEnum;
import com.debijenkorf.imageservice.provider.optimized.OptimizedImageProvider;
import com.debijenkorf.imageservice.provider.original.OriginalImageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageFetchingServiceImpl implements ImageFetchingService {
    private OptimizedImageProvider optimizedImageProvider;
    private OriginalImageProvider originalImageProvider;

    @Autowired
    public ImageFetchingServiceImpl(OptimizedImageProvider optimizedImageProvider, OriginalImageProvider originalImageProvider) {
        this.optimizedImageProvider = optimizedImageProvider;
        this.originalImageProvider = originalImageProvider;
    }

    @Override
    public AbstractImageType getOptimizedImage(String predefinedTypeName, String uniqueOriginalImageFilename, String dummySeoName) {
        Thumbnail thumbnail = new Thumbnail(1, 1, 1, ScaleTypeEnum.CROP, "test", TypeEnum.JPG);

        return thumbnail;
    }
}
