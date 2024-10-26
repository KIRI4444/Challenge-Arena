package com.example.Challenge.Arena.web.mappers;

import com.example.Challenge.Arena.domain.user.User;
import com.example.Challenge.Arena.web.dto.User.CreateUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateUserDtoMapper {

    CreateUserDto toDto(User user);

    User toEntity(CreateUserDto createUserDto);

}
