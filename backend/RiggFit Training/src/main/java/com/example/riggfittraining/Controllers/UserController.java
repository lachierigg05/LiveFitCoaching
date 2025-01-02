package com.example.riggfittraining.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import com.example.riggfittraining.Entities.User.User;
import com.example.riggfittraining.Services.UserService;

import java.util.Map;

@RestController
@RequestMapping("v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void createUser(@RequestBody String firstName, String lastName, String email, String username, String password) {
        try {
            userService.createUser(firstName, lastName, email, username, password);
        } catch(Exception e) {
            System.err.println("Error creating user: " + e.getMessage());
        }
    }

    @GetMapping
    public User getUserById(@RequestParam Long userId) {
        try {
            return userService.getUser(userId);
        } catch (Exception e) {
            System.err.println("Could not retrieve the user " + userId + " :" + e.getMessage());
            return null;
        }
    }

    @DeleteMapping
    public void deleteUser(@RequestParam Long userId) {
        try {
            userService.deleteUser(userId);
        } catch (Exception e) {
            System.err.println("Could not delete user " + userId + " :" + e.getMessage());
        }
    }

    @PutMapping
    public void updateUser(Long userId, @RequestBody Map<String, Object> updates) {
        try {
            userService.updateUser(userId, updates);
        } catch (Exception e) {
            System.err.println("Error updating user " + userId + ": " + e.getMessage());
        }
    }
}
