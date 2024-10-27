package com.example.Challenge.Arena.repository;

import com.example.Challenge.Arena.domain.challenge.Challenge;
import com.example.Challenge.Arena.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query("""
        SELECT ch FROM Challenge ch
        JOIN ch.users u
        WHERE u.id = :userId
        """)
    Set<Challenge> getAllChallengesByUserId(@Param("userId") Long userId);

}
