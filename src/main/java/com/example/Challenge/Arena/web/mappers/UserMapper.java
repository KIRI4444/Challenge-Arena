package com.example.Challenge.Arena.web.mappers;

import com.example.Challenge.Arena.domain.user.User;
import com.example.Challenge.Arena.web.dto.User.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

}
