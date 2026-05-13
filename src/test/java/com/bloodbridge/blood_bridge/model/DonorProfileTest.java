package com.bloodbridge.blood_bridge.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DonorProfileTest {
    DonorProfile donor ;

    @BeforeEach
    void createDonorObject() {
        donor = new DonorProfile();
    }
    @Test
    void testDonorId() {
        donor.setId(1L);
        assertEquals(1L, donor.getId());
    }
    @Test
    void testUser() {
        User user = new User();
        user.setId(1L);
        user.setName("Aryaa Verma");
        user.setPassword("Aryaa@123");
        user.setEmail("aryaa@gmail.com");
        user.setPhoneNumber("7865432176");

        donor.setUser(user);
        assertEquals(user, donor.getUser());
    }

    @Test
    void testDonorBloodGroup() {
        donor.setBloodGroup("Opos");
        assertEquals("Opos", donor.getBloodGroup());
    }

    @Test
    void testDonorCity() {
        donor.setCity("bhopal");
        assertEquals("bhopal", donor.getCity());
    }
    @Test
    void testDonorAvailability() {
        donor.setAvailable(true);
        assertTrue(donor.isAvailable());
    }

    @Test
    void testLastDonationDate(){
        donor.setLastDonationDate
                (LocalDate.of(2026,01,05));
        assertEquals
                (LocalDate.of(2026,01,05),
                        donor.getLastDonationDate());
    }
}
