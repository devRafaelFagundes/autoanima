package com.ieka.autoanima.controller.dto.response;

import com.ieka.autoanima.enums.UserRole;
import lombok.*;


@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMeResponse {
    private String name;
    private String email;
    private UserRole role;
}
