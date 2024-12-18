package com.example.riggfittraining.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.riggfittraining.Entities.user.User;
import com.example.riggfittraining.Repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepo;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void createUser(String firstName, String lastName, String email, String username, String password) {
        User user = new User(firstName, lastName, email, username, password);
        userRepo.save(user);
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
}