package com.grayseal.consoletaskmanager.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {

    @Test
    public void testConstructor() {
        Long id = 1L;
        String email = "test@example.com";
        String password = "password";
        User user = new User(id, email, password);

        assertNotNull(user);
        assertEquals(id, user.getId());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void testGettersAndSetters() {
        User user = new User();
        Long id = 1L;
        String email = "test@example.com";
        String password = "password";

        user.setId(id);
        user.setEmail(email);
        user.setPassword(password);

        assertEquals(id, user.getId());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
    }
}