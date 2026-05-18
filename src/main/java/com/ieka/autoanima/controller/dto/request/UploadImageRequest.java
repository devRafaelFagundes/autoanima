package com.ieka.autoanima.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UploadImageRequest {

    @NotBlank
    private String emotion;
}
