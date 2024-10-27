package com.example.Challenge.Arena.service;

import com.example.Challenge.Arena.domain.achievement.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AchievementService {
    Achievement getById(Long id);

    Achievement create(Achievement achievement);

    Achievement update(Achievement achievement);

    void delete(Long id);

    Set<Achievement> getAllAchievementsByUserId(Long id);

    void joinAchievement(Long challengeId, Long userId);

}
