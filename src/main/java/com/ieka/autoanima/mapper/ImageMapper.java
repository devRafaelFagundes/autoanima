package com.ieka.autoanima.mapper;

import com.ieka.autoanima.controller.dto.response.GetImageResponse;
import com.ieka.autoanima.controller.dto.response.UploadImageResponse;
import com.ieka.autoanima.domain.Image;

public class ImageMapper {
    public static UploadImageResponse toUploadResponse(Image image) {
        return new UploadImageResponse().builder().
                id(image.getId())
                .fileName(image.getFileName())
                .imageLink(image.getImageLink())
                .emotion(image.getEmotion())
                .build();
    }

    public static GetImageResponse toGetResponse(Image image) {
        return new GetImageResponse().builder().
                id(image.getId())
                .fileName(image.getFileName())
                .imageLink(image.getImageLink())
                .emotion(image.getEmotion())
                .build();
    }
}
