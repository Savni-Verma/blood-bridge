package com.bloodbridge.blood_bridge.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserObjectCreation() {
        User user = new User();

        user.setId(1L);
        user.setName("Shavni");
        user.setEmail("shavni@gmail.com");
        user.setPassword("password123");
        user.setPhoneNumber("9876543210");

        assertEquals(1L, user.getId());
        assertEquals("Shavni", user.getName());
        assertEquals("shavni@gmail.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals("9876543210", user.getPhoneNumber());
    }
}