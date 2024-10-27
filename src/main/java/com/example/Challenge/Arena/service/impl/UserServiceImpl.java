package com.example.Challenge.Arena.service.impl;

import com.example.Challenge.Arena.domain.challenge.Challenge;
import com.example.Challenge.Arena.domain.exception.ResourceNotFoundException;
import com.example.Challenge.Arena.domain.user.Role;
import com.example.Challenge.Arena.domain.user.User;
import com.example.Challenge.Arena.repository.ChallengeRepository;
import com.example.Challenge.Arena.repository.UserRepository;
import com.example.Challenge.Arena.service.UserService;
import com.example.Challenge.Arena.web.dto.User.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ChallengeRepository challengeRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    }

    @Override
    @Transactional
    public User update(UserDto userDto, Long id) {
        User user = userRepository.getById(id);
        user.setGoals(userDto.getGoals());
        user.setAge(userDto.getAge());
        user.setDescription(userDto.getDescription());
        user.setSex(userDto.getSex());
        userRepository.save(user);
        return user;

    }

    @Override
    @Transactional
    public User create(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalStateException("Username already exists");
        }

        if (!user.getPassword().equals(user.getPasswordConfirmation())) {
            throw new IllegalStateException("Passwords do not match");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = Set.of(Role.ROLE_USER);
        user.setRoles(roles);
        userRepository.save(user);

        return user;

    }

    @Override
    @Transactional
    public Set<Challenge> getAllChallengesByUserId(Long id) {
        return userRepository.getAllChallengesByUserId(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void joinChallenge(Long challengeId, Long userId) {
        User user = userRepository.getById(userId);
        Challenge challenge = challengeRepository.getById(challengeId);
        user.getChallenges().add(challenge);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void removeChallenge(Long challengeId, Long userId) {
        User user = userRepository.getById(userId);
        Challenge challenge = challengeRepository.getById(challengeId);
        user.getChallenges().remove(challenge);
        userRepository.save(user);
    }
}
