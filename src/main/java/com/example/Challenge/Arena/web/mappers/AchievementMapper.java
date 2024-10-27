package com.example.Challenge.Arena.web.mappers;

import com.example.Challenge.Arena.domain.achievement.Achievement;
import com.example.Challenge.Arena.web.dto.Achievement.AchievementDto;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface AchievementMapper {

    AchievementDto toDto(Achievement achievement);

    Achievement toEntity(AchievementDto achievementDto);

    Set<AchievementDto> toDto(Set<Achievement> achievements);

}
