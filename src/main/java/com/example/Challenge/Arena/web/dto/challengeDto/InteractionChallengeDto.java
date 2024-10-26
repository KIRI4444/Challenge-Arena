package com.example.Challenge.Arena.web.dto.challengeDto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InteractionChallengeDto {

    @NotNull(message = "userId must be not null")
    private long userId;

    @NotNull(message = "challengeId must be not null")
    private long challengeId;

}
