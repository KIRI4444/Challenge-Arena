package com.example.Challenge.Arena.web.controllers;

import com.example.Challenge.Arena.domain.user.User;
import com.example.Challenge.Arena.service.AuthService;
import com.example.Challenge.Arena.service.UserService;
import com.example.Challenge.Arena.web.dto.User.CreateUserDto;
import com.example.Challenge.Arena.web.dto.User.UserDto;
import com.example.Challenge.Arena.web.dto.auth.JwtRequest;
import com.example.Challenge.Arena.web.dto.auth.JwtResponse;
import com.example.Challenge.Arena.web.dto.auth.RefreshRequest;
import com.example.Challenge.Arena.web.dto.validation.OnCreate;
import com.example.Challenge.Arena.web.mappers.CreateUserDtoMapper;
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
    private final CreateUserDtoMapper createUserDtoMapper;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/login")
    public JwtResponse login(@Validated @RequestBody JwtRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public CreateUserDto register(@Validated(OnCreate.class) @RequestBody CreateUserDto createUserDto) {
        User user = createUserDtoMapper.toEntity(createUserDto);
        User createdUser = userService.create(user);
        return createUserDtoMapper.toDto(createdUser);
    }

    @PostMapping("/refresh")
    public JwtResponse refresh(@RequestBody RefreshRequest refreshRequest) {
        String refreshToken = refreshRequest.getRefreshToken();
        return authService.refresh(refreshToken);
    }

}
