package com.debijenkorf.imageservice.domain.images;

import com.debijenkorf.imageservice.domain.images.utils.ScaleTypeEnum;
import com.debijenkorf.imageservice.domain.images.utils.TypeEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class AbstractImageType {
    protected Integer height;
    protected Integer width;
    protected Integer quality;
    protected ScaleTypeEnum scaleType;
    protected String fillColor;
    protected TypeEnum type;

    public AbstractImageType(Integer height, Integer width, Integer quality, ScaleTypeEnum scaleType, String fillColor, TypeEnum type) {
        this.height = height;
        this.width = width;
        this.quality = quality;
        this.scaleType = scaleType;
        this.fillColor = fillColor;
        this.type = type;
    }
}
