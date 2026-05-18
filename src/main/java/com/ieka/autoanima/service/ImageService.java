package com.ieka.autoanima.service;

import com.ieka.autoanima.controller.dto.request.UploadImageRequest;
import com.ieka.autoanima.controller.dto.response.GetImageResponse;
import com.ieka.autoanima.controller.dto.response.UploadImageResponse;
import com.ieka.autoanima.domain.Image;
import com.ieka.autoanima.mapper.ImageMapper;
import com.ieka.autoanima.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final String FOLDER_PATH ="C:/Users/devra/Documents/projects/autoanima/autoanima/images";
    private final ImageRepository imageRepository;

    @Transactional
    public UploadImageResponse upload(MultipartFile file, UploadImageRequest request)  {
        String filePath = FOLDER_PATH + file.getOriginalFilename();

        Image image = imageRepository.save(Image.builder()
                .fileName(file.getOriginalFilename())
                .imageLink(filePath)
                .emotion(request.getEmotion())
                .build());

        try {
            file.transferTo(new File(filePath));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save the file.");
        }

        return ImageMapper.toUploadResponse(image);
    }

    public Page<GetImageResponse> getImages(Pageable pageable, Long userId) {
        return imageRepository.findByUserId(userId, pageable).map(ImageMapper::toGetResponse);
    }
}
