package com.example.Challenge.Arena.repository;

import com.example.Challenge.Arena.domain.challenge.Challenge;
import com.example.Challenge.Arena.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query(value = """
                    select * from challenges ch
                    join users_challenges u_ch on ch.id = u_ch.challenge_id
                    where u_ch.user_id = :userId
                    """, nativeQuery = true)
    Set<Challenge> getAllChallengesByUserId(@Param("userId") Long userId);
}
