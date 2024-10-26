package com.example.Challenge.Arena.repository;

import com.example.Challenge.Arena.domain.challenge.Challenge;
import com.example.Challenge.Arena.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    @Query(value = """
        select * from users u
        join users_challenges u_ch on u_ch.user_id = u.id
        where u_ch.challenge_id = :challengeId
        """, nativeQuery = true)
    Set<User> getAllUserByChallengeId(@Param("challengeId") Long challengeId);
}
