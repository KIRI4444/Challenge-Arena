package com.example.Challenge.Arena.web.controllers;

import com.example.Challenge.Arena.domain.challenge.Challenge;
import com.example.Challenge.Arena.domain.user.User;
import com.example.Challenge.Arena.service.ChallengeService;
import com.example.Challenge.Arena.service.UserService;
import com.example.Challenge.Arena.web.dto.User.UserDto;
import com.example.Challenge.Arena.web.dto.challengeDto.ChallengeDto;
import com.example.Challenge.Arena.web.mappers.ChallengeMapper;
import com.example.Challenge.Arena.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;
    private final ChallengeService challengeService;

    private final UserMapper userMapper;
    private final ChallengeMapper challengeMapper;

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @GetMapping("/username/{username}")
    public UserDto getByUsername(@PathVariable String username) {
        User user = userService.getByUsername(username);
        return userMapper.toDto(user);
    }

    @PostMapping("/edit/{id}")
    public UserDto edit(@PathVariable Long id, @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User updatedUser = userService.update(user);
        return userMapper.toDto(updatedUser);
    }

    @GetMapping("/challenges/{id}")
    public Set<ChallengeDto> getChallenges(@PathVariable Long id) {
        System.out.println("getChallenges:" + id);
        Set<Challenge> challenges = userService.getAllChallengesByUserId(id);
        System.out.println("Получили челленджи");
        Set<ChallengeDto> challengesDto = challengeMapper.toDto(challenges);
        System.out.println("Сконвертировали челленджи");
        return challengesDto;
    }
}
