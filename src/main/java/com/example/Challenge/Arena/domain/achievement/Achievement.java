package com.example.Challenge.Arena.domain.achievement;

import com.example.Challenge.Arena.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "achievements")
@Data
public class Achievement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "achievements")
    private Set<User> achievements;

}
