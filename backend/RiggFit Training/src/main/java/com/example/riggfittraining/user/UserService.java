package com.example.riggfittraining.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void createUser(User user) {
        if (userRepo.existsById(user.getUser_id())) {
            throw new IllegalArgumentException("user_id already exists");
        }
        userRepo.save(user);
    }
}