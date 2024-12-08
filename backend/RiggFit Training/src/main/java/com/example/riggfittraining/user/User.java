package com.example.riggfittraining.user;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="users")

@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = true)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    public User(String firstName, String lastName, String email, String username, String password) {
        this.user_id = generateUserId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User() {}

    public Long generateUserId() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    public Long getUser_id() {
        return user_id;
    }
}
