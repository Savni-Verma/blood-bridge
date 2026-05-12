package com.bloodbridge.blood_bridge.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DonorProfileTest {
    @Test
    void testDonorProfileFields() {
        User user = new User();
        user.setId(1L);
        user.setName("Aryaa Verma");
        user.setPassword("Aryaa@123");
        user.setEmail("aryaa@gmail.com");
        user.setPhoneNumber("7865432176");

        DonorProfile donor = new DonorProfile();
        donor.setId(1L);
        donor.setUser(user);
        donor.setBloodGroup("Opos");
        donor.setCity("bhopal");
        donor.setAvailable(true);
        donor.setLastDonationDate(LocalDate.of(2026,01,05));

       assertEquals(1L,donor.getId());
       assertEquals(user,donor.getUser());
       assertEquals("Opos" , donor.getBloodGroup());
       assertEquals("bhopal",donor.getCity());
       assertTrue(donor.isAvailable());
       assertEquals(LocalDate.of(2026,01,05),donor.getLastDonationDate());

    }
}
