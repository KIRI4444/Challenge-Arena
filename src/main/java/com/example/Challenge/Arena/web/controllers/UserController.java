package com.example.Challenge.Arena.web.controllers;

import com.example.Challenge.Arena.domain.challenge.Challenge;
import com.example.Challenge.Arena.domain.user.User;
import com.example.Challenge.Arena.service.UserService;
import com.example.Challenge.Arena.web.dto.User.EditUserProfileDto;
import com.example.Challenge.Arena.web.dto.User.UserDto;
import com.example.Challenge.Arena.web.dto.challengeDto.InteractionChallengeDto;
import com.example.Challenge.Arena.web.dto.challengeDto.ChallengeDto;
import com.example.Challenge.Arena.web.mappers.ChallengeMapper;
import com.example.Challenge.Arena.web.mappers.EditUserProfileDtoMapper;
import com.example.Challenge.Arena.web.mappers.UserMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
@Tag(name = "User Controller", description = "User API")
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;
    private final ChallengeMapper challengeMapper;
    private final EditUserProfileDtoMapper editUserProfileDtoMapper;

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
    public EditUserProfileDto edit(@PathVariable Long id, @RequestBody EditUserProfileDto editUserProfileDto) {
        User user = userService.getById(id);

        user.setGoals(editUserProfileDto.getGoals());
        user.setAge(editUserProfileDto.getAge());
        user.setDescription(editUserProfileDto.getDescription());
        user.setSex(editUserProfileDto.getSex());

        userService.save(user);

        return editUserProfileDtoMapper.toDto(user);
    }

    @GetMapping("/challenges/{id}")
    public Set<ChallengeDto> getChallenges(@PathVariable Long id) {
        Set<Challenge> challenges = userService.getAllChallengesByUserId(id);
        Set<ChallengeDto> challengesDto = challengeMapper.toDto(challenges);
        return challengesDto;
    }
    
    @PostMapping("/add/challenge")
    public InteractionChallengeDto addChallenge(@RequestBody InteractionChallengeDto interactionChallengeDto) {
        userService.joinChallenge(interactionChallengeDto.getChallengeId(), interactionChallengeDto.getUserId());
        return interactionChallengeDto;
    }

    @PostMapping("/remove/challenge")
    public InteractionChallengeDto removeChallenge(@RequestBody InteractionChallengeDto interactionChallengeDto) {
        userService.removeChallenge(interactionChallengeDto.getChallengeId(), interactionChallengeDto.getUserId());
        return interactionChallengeDto;
    }
}
