package com.ieka.autoanima.mapper;

import com.ieka.autoanima.controller.dto.response.UserMeResponse;
import com.ieka.autoanima.domain.User;

public class UserMapper {
    public static UserMeResponse toMeResponse(User user){
        return UserMeResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
