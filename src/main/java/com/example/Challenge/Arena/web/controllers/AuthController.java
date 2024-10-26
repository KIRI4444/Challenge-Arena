package com.example.Challenge.Arena.web.controllers;

import com.example.Challenge.Arena.domain.user.User;
import com.example.Challenge.Arena.service.AuthService;
import com.example.Challenge.Arena.service.UserService;
import com.example.Challenge.Arena.web.dto.User.UserDto;
import com.example.Challenge.Arena.web.dto.auth.JwtRequest;
import com.example.Challenge.Arena.web.dto.auth.JwtResponse;
import com.example.Challenge.Arena.web.dto.auth.RefreshRequest;
import com.example.Challenge.Arena.web.dto.validation.OnCreate;
import com.example.Challenge.Arena.web.mappers.UserMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
@Tag(name = "Auth Controller", description = "Auth API")

public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    private final UserMapper userMapper;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/login")
    public JwtResponse login(@Validated @RequestBody JwtRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public UserDto register(@Validated(OnCreate.class) @RequestBody UserDto userDto) {
        System.out.println("Запрос дошел:" + userDto);
        User user = userMapper.toEntity(userDto);
        System.out.println("юзер переделан в сущность");
        User createdUser = userService.create(user);
        System.out.println("юзер создан");
        return userMapper.toDto(createdUser);
    }

    @PostMapping("/refresh")
    public JwtResponse refresh(@RequestBody RefreshRequest refreshRequest) {
        String refreshToken = refreshRequest.getRefreshToken();
        return authService.refresh(refreshToken);
    }

}
