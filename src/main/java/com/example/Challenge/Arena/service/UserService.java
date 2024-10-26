package com.example.Challenge.Arena.service;

import com.example.Challenge.Arena.domain.challenge.Challenge;
import com.example.Challenge.Arena.domain.user.User;
import com.example.Challenge.Arena.web.dto.User.UserDto;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {

    User getById(Long id);

    User getByUsername(String username);

    User update(UserDto userDto, Long id);

    User create(User user);

    void save(User user);

    Set<Challenge> getAllChallengesByUserId(Long id);

    void delete(Long id);

    void joinChallenge(Long challengeId, Long userId);

    void removeChallenge(Long challengeId, Long userId);

}
