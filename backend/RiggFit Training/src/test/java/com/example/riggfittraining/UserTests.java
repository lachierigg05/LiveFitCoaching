package com.example.riggfittraining;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.riggfittraining.Entities.user.User;

/**
 * Test class for User-related functionality.
 */
public class UserTests {
    private User user; 
    
    @BeforeEach
    public void setUp() {
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
     * Test to ensure the setter for the first name functions correctly.
     */
    @Test
    public void setFirstNameTest() {
        user.setFirstName("newName");
        assertEquals("newName", user.getFirstName());
    }

    /**
     * Tests to ensure the getter for the first name functions correctly.
     */
    @Test
    public void getFirstNameTest() {
        assertEquals("user", user.getFirstName());
    }

    /**
     * Test to ensure the setter for the last name functions correctly.
     */
    @Test
    public void setLastNameTest() {
        user.setLastName("newName");
        assertEquals("newName", user.getLastName());
    }

    /**
     * Tests to ensure the getter for the last name functions correctly.
     */
    @Test
    public void getLastNameTest() {
        assertEquals("test", user.getLastName());
    }

    /**
     * Test to ensure the setter for the email functions correctly.
     */
    @Test
    public void setEmailTest() {
        user.setEmail("newEmail@email.com");
        assertEquals("newEmail@email.com", user.getEmail());
    }

    /**
     * Tests to ensure the getter for the email functions correctly.
     */
    @Test
    public void getEmailTest() {
        assertEquals("usertest@user.com", user.getEmail());
    }

    /**
     * Test to ensure the setter for the username functions correctly.
     */
    @Test
    public void setUsernameTest() {
        user.setUsername("newUsername");
        assertEquals("newUsername", user.getUsername());
    }

    /**
     * Tests to ensure the getter for the username functions correctly.
     */
    @Test
    public void getUsernameTest() {
        assertEquals("username", user.getUsername());
    }

    /**
     * Test to ensure the setter for the password functions correctly.
     */
    @Test
    public void setPasswordTest() {
        user.setPassword("newPassword");
        assertEquals("newPassword", user.getPassword());
    }

    /**
     * Tests to ensure the getter for the password functions correctly.
     */
    @Test
    public void getPasswordTest() {
        assertEquals("password", user.getPassword());
    }
}

