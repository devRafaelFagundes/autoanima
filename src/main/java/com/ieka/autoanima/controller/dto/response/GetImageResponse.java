package com.ieka.autoanima.controller.dto.response;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetImageResponse {
    private Long id;
    private String fileName;
    private String imageLink;
    private String emotion;
}
