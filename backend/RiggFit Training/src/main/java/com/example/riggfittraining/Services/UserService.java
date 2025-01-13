package com.example.riggfittraining.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.riggfittraining.Entities.User.User;
import com.example.riggfittraining.Repositories.UserRepository;

import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepo;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void deleteUser(Long user_id) {
        if (!userRepo.existsById(user_id)) {
            logger.error("Attempted to delete user with user_id that does not exist");
            throw new IllegalArgumentException("user_id does not exist");
        }
        userRepo.deleteById(user_id);
    }

    public User getUser(Long user_id) {
        if (!userRepo.existsById(user_id)) {
            logger.error("Attempted gertUser with user_id that does not exist");
            throw new IllegalArgumentException("user_id does not exist");
        }
        return userRepo.findById(user_id)
                .orElseThrow(() -> {
                    logger.error("Attempted getUser with user_id that does not exist");
                    return new IllegalArgumentException("user_id does not exist");
                });    }

    public void updateUser(Long userId, Map<String, Object> updates) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User " + userId + " not found."));
        updates.forEach((key, value) -> {
            switch(key) {
                case "firstName":
                    user.setFirstName((String) value);
                case "lastName":
                    user.setLastName((String) value);
                case "email":
                    user.setEmail((String) value);
                case "username":
                    user.setUsername((String) value);
                case "password":
                    user.setPassword((String) value);
                default:
                    throw new IllegalArgumentException("Invalid field: " + key);
            }
        });

        userRepo.save(user);
    }
}