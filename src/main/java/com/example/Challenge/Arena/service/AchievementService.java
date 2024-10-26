package com.example.Challenge.Arena.service;

import com.example.Challenge.Arena.domain.achievement.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchievementService extends JpaRepository<Achievement, Long> {
}
