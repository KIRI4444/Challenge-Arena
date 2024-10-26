package com.example.Challenge.Arena.web.dto.User;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserDto {

    @NotNull(message = "Id must be not null")
    private long id;

    @NotNull(message = "Name must be not null")
    @Length(min = 5, max = 255, message = "Name length maust be between 5 and 255 symbols")
    private String name;
}
