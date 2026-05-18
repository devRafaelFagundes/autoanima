package com.ieka.autoanima.controller.dto.request;

import com.ieka.autoanima.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record UserRegisterRequest (
        @NotBlank String name,
        @Email String email,
        @NotBlank @Length(min = 6) String password,
        @NotNull UserRole role
)
{}
