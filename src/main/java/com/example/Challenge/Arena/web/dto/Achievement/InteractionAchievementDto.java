package com.example.Challenge.Arena.web.dto.Achievement;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InteractionAchievementDto {

    @NotNull(message = "userId must be not null")
    private long userId;

    @NotNull(message = "AchievementId must be not null")
    private long achievementId;
}
