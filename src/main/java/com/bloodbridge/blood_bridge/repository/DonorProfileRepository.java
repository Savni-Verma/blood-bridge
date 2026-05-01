package com.bloodbridge.blood_bridge.repository;

import com.bloodbridge.blood_bridge.model.DonorProfile;
import com.bloodbridge.blood_bridge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DonorProfileRepository
        extends JpaRepository<DonorProfile,Long> {
    Optional<DonorProfile> findByUser(User user);//jab koi donor apni profile serach karega
    // toh user object se profile dhundege

    List<DonorProfile> findByCityAndBloodGroupAndAvailableTrue
            (String city , String bloodGroup);
    /*
    Seeker jab search kare toh sirf:
    Usi city ke donors
    Usi blood group ke donors
    Jo available hain — available = true
     */
}
