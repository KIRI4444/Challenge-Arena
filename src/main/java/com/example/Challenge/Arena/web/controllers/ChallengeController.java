package com.example.Challenge.Arena.web.controllers;

import com.example.Challenge.Arena.domain.challenge.Challenge;
import com.example.Challenge.Arena.service.ChallengeService;
import com.example.Challenge.Arena.web.dto.challengeDto.ChallengeDto;
import com.example.Challenge.Arena.web.mappers.ChallengeMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/challenges")
@RequiredArgsConstructor
@Validated
@Tag(name = "Challenge Controller", description = "Challenge API")
public class ChallengeController {

    private final ChallengeService challengeService;
    private final ChallengeMapper challengeMapper;

    @PostMapping("/create")
    public ChallengeDto createChallenge(@RequestBody ChallengeDto challengeDto) {
        Challenge challenge = challengeMapper.toEntity(challengeDto);
        Challenge savedChallenge = challengeService.create(challenge);
        return challengeMapper.toDto(savedChallenge);
    }

    @PostMapping("/update")
    public ChallengeDto updateChallenge(@RequestBody ChallengeDto challengeDto) {
        Challenge challenge = challengeMapper.toEntity(challengeDto);
        Challenge updatedChallenge = challengeService.update(challenge);
        return challengeMapper.toDto(updatedChallenge);
    }
}
