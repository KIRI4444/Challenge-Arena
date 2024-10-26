package com.example.Challenge.Arena.web.mappers;

import com.example.Challenge.Arena.domain.challenge.Challenge;
import com.example.Challenge.Arena.web.dto.challengeDto.ChallengeDto;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ChallengeMapper {

    ChallengeDto toDto(Challenge challenge);

    Challenge toEntity(ChallengeDto challengeDto);

    Set<ChallengeDto> toEntity(Set<Challenge> challenges);

    Set<ChallengeDto> toDto(Set<Challenge> challenges);
}
