package com.example.Challenge.Arena.service;

import com.example.Challenge.Arena.web.dto.auth.JwtRequest;
import com.example.Challenge.Arena.web.dto.auth.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);

}
