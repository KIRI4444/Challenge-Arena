package com.example.Challenge.Arena.web.mappers;

import com.example.Challenge.Arena.domain.user.User;
import com.example.Challenge.Arena.web.dto.User.EditUserProfileDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EditUserProfileDtoMapper {

    EditUserProfileDto toDto(User user);

    User toEntity(EditUserProfileDto editUserProfileDto);

}
