package com.example.riggfittraining.User;

import com.example.riggfittraining.user.User;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;

/**
 * Test class for User-related functionality.
 */
public class UserTests {
    private User user; 
    
    @BeforeEach
    private void setUp() {
        user = new User("user", "test", "usertest@user.com", "username", "password"); 
    }
    
    /**
     * Test to ensure that a newly create user successfully creates a user object
     */
    @Test
    public void createUserTest() {
        assertNotNull(user);
        assertInstanceOf(User.class, user);
    }

    /**
     * Test to ensure that changing the first name of the user saves the name  
     * correctly to the class.
     */
    @Test
    public void setFirstNameTest() {
        assertEquals("user", user.getFirstName());
        user.setFirstName("newName");
        assertEquals("newName", user.getFirstName());
    }
    
}
