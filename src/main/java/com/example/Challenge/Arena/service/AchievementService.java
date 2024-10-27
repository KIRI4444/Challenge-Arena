package com.example.Challenge.Arena.service;

import com.example.Challenge.Arena.domain.achievement.Achievement;

import java.util.Set;

public interface AchievementService {
    Achievement getById(Long id);

    Achievement create(Achievement achievement);

    Achievement update(Achievement achievement);

    Set<Achievement> getAllAchievementsByUserId(Long id);

    void joinAchievement(Long challengeId, Long userId);

}
