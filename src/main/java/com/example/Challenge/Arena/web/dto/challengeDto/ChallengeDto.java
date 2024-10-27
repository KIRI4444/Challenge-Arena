package com.example.Challenge.Arena.web.dto.challengeDto;

import com.example.Challenge.Arena.web.dto.validation.OnCreate;
import com.example.Challenge.Arena.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class ChallengeDto {

    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    private long id;

    @NotNull(message = "Description must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(min = 1, max = 255, message = "Description must be less than 255 sembols")
    private String description;

    @NotNull(message = "Rules must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(min = 1, max = 255, message = "Rules must be less than 255 sembols")
    private String rules;

    @NotNull(message = "Title must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(min = 1, max = 255, message = "Title must be less than 255 sembols")
    private String title;

    @NotNull(message = "Type must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(min = 1, max = 255, message = "Type must be less than 255 sembols")
    private String type;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;

}
