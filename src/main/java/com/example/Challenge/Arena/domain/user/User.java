package com.example.Challenge.Arena.domain.user;

import com.example.Challenge.Arena.domain.achievement.Achievement;
import com.example.Challenge.Arena.domain.challenge.Challenge;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String password;

    @Transient
    private String passwordConfirmation;

    private String name;
    private String username;
    private String goals;
    private int age;
    private String description;
    private int sex;

    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "users_roles")
    @Enumerated(value = EnumType.STRING)
    private Set<Role> roles;

    @ManyToMany
    @JoinTable(
            name = "users_challenges",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "challenge_id")
    )
    private Set<Challenge> challenges;

    @ManyToMany
    @JoinTable(
            name = "users_achievements",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "achievement_id")
    )
    private Set<Achievement> achievements;

}
