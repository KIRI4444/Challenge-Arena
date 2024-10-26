package com.example.Challenge.Arena.web.dto.User;

import com.example.Challenge.Arena.web.dto.validation.OnCreate;
import com.example.Challenge.Arena.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserDto {

    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    private long id;

    @NotNull(message = "Name must be not null")
    @Length(min = 5, max = 255, message = "Name length must be between 5 and 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    private String name;

    @NotNull(message = "Username must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(min = 3, max = 255, message = "Username length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String username;

    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(min = 9, max = 255, message = "suck ants fuck zhopa", groups = {OnUpdate.class, OnCreate.class})
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password confirmation must be not null", groups = OnCreate.class)
    @Length(min = 9, max = 255, message = "suck ants fuck zhopa", groups = {OnUpdate.class, OnCreate.class})
    private String passwordConfirmation;

    @NotNull(message = "Goals must be not null", groups = OnUpdate.class)
    @Length(max = 255, groups = {OnUpdate.class, OnCreate.class})
    private String goals;

    @NotNull(message = "Age must be not null", groups = {OnUpdate.class, OnCreate.class})
    private int age;

    @Length(max = 1025, groups = {OnUpdate.class, OnCreate.class})
    private String description;

    @NotNull(message = "Sex must be not null")
    private int sex;

}
