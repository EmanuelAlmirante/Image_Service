package com.debijenkorf.imageservice.domain.images;

import com.debijenkorf.imageservice.domain.images.utils.ScaleTypeEnum;
import com.debijenkorf.imageservice.domain.images.utils.TypeEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class Thumbnail extends AbstractImageType {
    public Thumbnail(Integer height, Integer width, Integer quality, ScaleTypeEnum scaleType, String fillColor, TypeEnum type) {
        super(height, width, quality, scaleType, fillColor, type);
    }
}
