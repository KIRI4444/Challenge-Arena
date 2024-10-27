package com.example.Challenge.Arena.service.impl;

import com.example.Challenge.Arena.domain.achievement.Achievement;
import com.example.Challenge.Arena.domain.exception.ResourceNotFoundException;
import com.example.Challenge.Arena.domain.user.User;
import com.example.Challenge.Arena.repository.AchievementRepository;
import com.example.Challenge.Arena.repository.UserRepository;
import com.example.Challenge.Arena.service.AchievementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@AllArgsConstructor
public class AchievementServiceImpl implements AchievementService {
    private final AchievementRepository achievementRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Achievement getById(Long id) {
        return achievementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Achievement not found"));
    }

    @Override
    @Transactional
    public Achievement create(Achievement achievement) {
        return achievementRepository.save(achievement);
    }

    @Override
    @Transactional
    public Achievement update(Achievement achievement) {
        achievementRepository.save(achievement);
        return achievement;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        achievementRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Set<Achievement> getAllAchievementsByUserId(Long id) {
        return achievementRepository.getAllUserAchievements(id);
    }

    @Override
    @Transactional
    public void joinAchievement(Long challengeId, Long userId) {
        Achievement achievement = achievementRepository.getById(challengeId);
        User user = userRepository.getById(userId);
        user.getAchievements().add(achievement);
        userRepository.save(user);
    }
}
