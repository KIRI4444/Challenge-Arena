package com.example.Challenge.Arena.service.impl;

import com.example.Challenge.Arena.domain.challenge.Challenge;
import com.example.Challenge.Arena.domain.exception.ResourceNotFoundException;
import com.example.Challenge.Arena.domain.user.User;
import com.example.Challenge.Arena.repository.ChallengeRepository;
import com.example.Challenge.Arena.service.ChallengeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {

   private final ChallengeRepository challengeRepository;


    @Override
    @Transactional(readOnly = true)
    public Challenge getById(Long id) {
        return challengeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Challenge not found"));
    }

    @Override
    @Transactional
    public Challenge create(Challenge challenge) {
        if (challenge.getUsers() == null) {
            challenge.setUsers(new HashSet<>());
        }

        return challengeRepository.save(challenge);
    }

    @Override
    @Transactional
    public Challenge update(Challenge challenge) {
        if(challenge.getDate() == null) {
            challenge.setDate(LocalDateTime.now());
        }
        challengeRepository.save(challenge);
        return challenge;
    }

    @Override
    @Transactional
    public void delete(Long id) {
         challengeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Set<User> getAllUserByChallengeId(Long id) {
        return challengeRepository.getAllUserByChallengeId(id);
    }

    @Override
    @Transactional
    public Set<Challenge> getChallengesByDate(LocalDateTime dateFrom, LocalDateTime dateTo) {
        Set<Challenge> challenges = challengeRepository.findByDateBetween(dateFrom, dateTo);
        return challenges;
    }
}
