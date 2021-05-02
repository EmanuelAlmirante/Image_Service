package com.debijenkorf.imageservice.controller;

import com.debijenkorf.imageservice.controller.utils.exception.NoPredefinedImageTypeException;
import com.debijenkorf.imageservice.controller.utils.images.PredefinedImageTypeEnum;
import com.debijenkorf.imageservice.domain.images.AbstractImageType;
import com.debijenkorf.imageservice.provider.utils.NoImageException;
import com.debijenkorf.imageservice.provider.utils.ProviderServerException;
import com.debijenkorf.imageservice.service.fetching.ImageFetchingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/image-service")
public class ImageServiceController {
    private final ImageFetchingService imageFetchingService;

    @Autowired
    public ImageServiceController(ImageFetchingService imageFetchingService) {
        this.imageFetchingService = imageFetchingService;
    }

    @GetMapping(value = {"/image/show/{predefinedTypeName}/",
                         "/image/show/{predefinedTypeName}/{dummySeoName}/"})
    @ResponseStatus(HttpStatus.OK)
    public AbstractImageType getOptimizedImage(@PathVariable(name = "predefinedTypeName") String predefinedTypeName,
                                               @RequestParam(name = "reference") String uniqueOriginalImageFilename,
                                               @PathVariable(name = "dummySeoName", required = false)
                                                       String dummySeoName)
            throws NoPredefinedImageTypeException, ProviderServerException, NoImageException {
        if (PredefinedImageTypeEnum.predefinedImageTypeEnumStream().noneMatch(
                predefinedImageTypeEnum -> predefinedImageTypeEnum.getPredefinedImageType()
                                                                  .equals(predefinedTypeName))) {
            log.info("Invalid predefined image type {} does not exist", predefinedTypeName);
            throw new NoPredefinedImageTypeException("Predefined type image does not exist - " + predefinedTypeName);
        }

        if (dummySeoName == null) {
            return imageFetchingService.getOptimizedImage(predefinedTypeName, uniqueOriginalImageFilename);
        }

        return imageFetchingService.getOptimizedImage(predefinedTypeName, uniqueOriginalImageFilename, dummySeoName);
    }
}
