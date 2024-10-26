package com.example.Challenge.Arena.web.dto.Achievement;

import com.example.Challenge.Arena.web.dto.validation.OnCreate;
import com.example.Challenge.Arena.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AchievementDto {

    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    private long id;

    @NotNull(message = "Name must be not null")
    @Length(min = 1, max = 255, message = "Name must be between 1 and 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    private String name;

}
