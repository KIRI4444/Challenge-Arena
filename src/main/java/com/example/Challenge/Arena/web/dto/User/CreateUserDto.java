package com.example.Challenge.Arena.web.dto.User;

import com.example.Challenge.Arena.web.dto.validation.OnCreate;
import com.example.Challenge.Arena.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CreateUserDto {

    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    private long id;

    @NotNull(message = "Name must be not null")
    @Length(min = 5, max = 255, message = "Name length maust be between 5 and 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    private String name;

    @NotNull(message = "Username must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(min = 3, max = 255, message = "Username length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(min = 5, max = 255, groups = {OnUpdate.class, OnCreate.class})
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password confirmation must be not null", groups = OnCreate.class)
    @Length(min = 7, max = 255, groups = {OnUpdate.class, OnCreate.class})
    private String passwordConfirmation;

}
