package com.example.Challenge.Arena.web.dto.auth;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RefreshRequest {

    @NotNull(message = "Refresh token must be not null")
    private String refreshToken;

}
