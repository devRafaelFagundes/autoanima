package com.ieka.autoanima.controller.dto.response;

public record UserLoginResponse(String token, Integer expiresIn) {
}
