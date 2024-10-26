package com.example.Challenge.Arena.repository;

import com.example.Challenge.Arena.domain.achievement.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {

    @Query(value = """
            select * from achievements ach
            join users_achievements u_ach on ach.id = u_ach.achievement_id
            where user_id = :userId
            """, nativeQuery = true)
    Set<Achievement> getAllUserAchievements(@Param("userId") Long userId);
}
