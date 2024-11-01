package com.example.Challenge.Arena.web.controllers;

import com.example.Challenge.Arena.domain.challenge.Challenge;
import com.example.Challenge.Arena.service.ChallengeService;
import com.example.Challenge.Arena.web.dto.challengeDto.ChallengeDto;
import com.example.Challenge.Arena.web.dto.challengeDto.CheckChallengesDto;
import com.example.Challenge.Arena.web.mappers.ChallengeMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/challenges")
@RequiredArgsConstructor
@Validated
@Tag(name = "Challenge Controller", description = "Challenge API")
public class ChallengeController {

    private final ChallengeService challengeService;
    private final ChallengeMapper challengeMapper;

    //admin
    @PostMapping("/create")
    @PreAuthorize("@CustomSecurityExpression.isUserAdmin()")
    public ChallengeDto createChallenge(@RequestBody ChallengeDto challengeDto) {
        Challenge challenge = challengeMapper.toEntity(challengeDto);
        Challenge savedChallenge = challengeService.create(challenge);
        return challengeMapper.toDto(savedChallenge);
    }

    //admin
    @PostMapping("/update")
    @PreAuthorize("@CustomSecurityExpression.isUserAdmin()")
    public ChallengeDto updateChallenge(@RequestBody ChallengeDto challengeDto) {
        Challenge challenge = challengeMapper.toEntity(challengeDto);
        Challenge updatedChallenge = challengeService.update(challenge);
        return challengeMapper.toDto(updatedChallenge);
    }

    @PostMapping("")
    public Set<ChallengeDto> viewChallenges(@RequestBody CheckChallengesDto checkChallengesDto) {
        LocalDateTime dateFrom = checkChallengesDto.getDateFrom();
        LocalDateTime dateTo = checkChallengesDto.getDateTo();
        Set<Challenge> challenges = challengeService.getChallengesByDate(dateFrom, dateTo);
        Set<ChallengeDto> challengeDtoSet = challengeMapper.toDto(challenges);
        return challengeDtoSet;
    }
}
