package com.example.Challenge.Arena.domain.challenge;

import com.example.Challenge.Arena.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "challenges")
@Data
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;
    private String rules;
    private LocalDateTime date;
    private String type;

    @ManyToMany(mappedBy = "challenges")
    private Set<User> users;

}
