package com.example.Challenge.Arena.service;

import com.example.Challenge.Arena.domain.challenge.Challenge;
import com.example.Challenge.Arena.domain.user.User;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface ChallengeService {

    Challenge getById(Long id);

    Challenge create(Challenge challenge);

    Challenge update(Challenge challenge);

    void delete(Long id);

    Set<User> getAllUserByChallengeId(Long id);
}
