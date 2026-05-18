package com.ieka.autoanima.controller;

import com.ieka.autoanima.controller.dto.request.UserLoginRequest;
import com.ieka.autoanima.controller.dto.request.UserRegisterRequest;
import com.ieka.autoanima.controller.dto.response.UserLoginResponse;
import com.ieka.autoanima.controller.dto.response.UserMeResponse;
import com.ieka.autoanima.domain.User;
import com.ieka.autoanima.infra.security.TokenService;
import com.ieka.autoanima.mapper.UserMapper;
import com.ieka.autoanima.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final TokenService tokenService;

    @PostMapping("/login")
    public UserLoginResponse login(@RequestBody @Valid UserLoginRequest request) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        var expiresIn = tokenService.getTOKEN_EXPIRATION_TIME_MINUTES() * 60;
        return new UserLoginResponse(token, expiresIn);
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid UserRegisterRequest request) {
        userService.register(request);
    }

    @GetMapping("/me")
    public UserMeResponse me(
            @AuthenticationPrincipal User user
    ) {
        return UserMapper.toMeResponse(user);
    }
}
