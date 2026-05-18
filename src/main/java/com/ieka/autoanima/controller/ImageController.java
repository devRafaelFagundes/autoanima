package com.ieka.autoanima.controller;

import com.ieka.autoanima.controller.dto.request.UploadImageRequest;
import com.ieka.autoanima.controller.dto.response.GetImageResponse;
import com.ieka.autoanima.controller.dto.response.UploadImageResponse;
import com.ieka.autoanima.service.ImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping
    public Page<GetImageResponse> getImage(@RequestParam Pageable pageable, @PathVariable Long userId) {
        return imageService.getImages(pageable, userId);
    }

    @PostMapping("/upload")
    public UploadImageResponse uploadImage(@RequestPart("file") MultipartFile file, @RequestPart @Valid UploadImageRequest request) {
        return imageService.upload(file, request);
    }
}
