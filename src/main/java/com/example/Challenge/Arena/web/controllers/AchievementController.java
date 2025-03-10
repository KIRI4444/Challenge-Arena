package com.example.Challenge.Arena.web.controllers;

import com.example.Challenge.Arena.domain.achievement.Achievement;
import com.example.Challenge.Arena.service.AchievementService;
import com.example.Challenge.Arena.web.dto.Achievement.AchievementDto;
import com.example.Challenge.Arena.web.dto.Achievement.InteractionAchievementDto;
import com.example.Challenge.Arena.web.mappers.AchievementMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/achievement")
@RequiredArgsConstructor
@Validated
@Tag(name = "Achievement Controller", description = "Achievement API")
public class AchievementController {

    private final AchievementService achievementService;
    private final AchievementMapper achievementMapper;

    @GetMapping("/{id}")
    @Transactional
    public Set<AchievementDto> getUserAchievementsById(@PathVariable Long id) {
        Set<Achievement> achievements = achievementService.getAllAchievementsByUserId(id);
        Set<AchievementDto> achievementDto = achievementMapper.toDto(achievements);
        return achievementDto;
    }

    //admin
    @PostMapping("/add")
    @PreAuthorize("@CustomSecurityExpression.isUserAdmin()")
    @Transactional
    public InteractionAchievementDto addAchievementToUser(@RequestBody InteractionAchievementDto interactionChallengeDto) {
        achievementService.joinAchievement(interactionChallengeDto.getAchievementId(), interactionChallengeDto.getUserId());
        return interactionChallengeDto;
    }

    //admin
    @PostMapping("/create")
    @PreAuthorize("@CustomSecurityExpression.isUserAdmin()")
    @Transactional
    public AchievementDto createAchievement(@RequestBody AchievementDto achievementDto) {
        Achievement achievement = achievementMapper.toEntity(achievementDto);
        Achievement savedAchievement = achievementService.create(achievement);
        return achievementMapper.toDto(savedAchievement);
    }

    //admin
    @PostMapping("/update")
    @PreAuthorize("@CustomSecurityExpression.isUserAdmin()")
    @Transactional
    public AchievementDto updateAchievement(@RequestBody AchievementDto achievementDto) {
        Achievement achievement = achievementMapper.toEntity(achievementDto);
        Achievement updatedAchievement = achievementService.update(achievement);
        return achievementMapper.toDto(updatedAchievement);
    }

}