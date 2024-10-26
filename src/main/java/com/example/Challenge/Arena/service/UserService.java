package com.example.Challenge.Arena.service;

import com.example.Challenge.Arena.domain.challenge.Challenge;
import com.example.Challenge.Arena.domain.user.User;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {

    User getById(Long id);

    User getByUsername(String username);

    User update(User user);

    User create(User user);

    Set<Challenge> getAllChallengesByUserId(Long id);

    void delete(Long id);

}
