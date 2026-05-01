package com.bloodbridge.blood_bridge.service;

import com.bloodbridge.blood_bridge.exception.ResourceNotFoundException;
import com.bloodbridge.blood_bridge.model.DonorProfile;
import com.bloodbridge.blood_bridge.model.User;
import com.bloodbridge.blood_bridge.repository.DonorProfileRepository;
import com.bloodbridge.blood_bridge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DonorService {

    private final DonorProfileRepository donorProfileRepository;
    private final UserRepository userRepository;

    @Transactional
    public DonorProfile saveProfile(User user, String bloodGroup, String city,
                                    LocalDate lastDonationDate) {

        // Pehle se profile hai?
        DonorProfile profile = donorProfileRepository
                .findByUser(user)
                .orElse(new DonorProfile()); // nahi hai toh naya banao

        profile.setUser(user);
        profile.setBloodGroup(bloodGroup);
        profile.setCity(city);
        profile.setLastDonationDate(lastDonationDate);

        return donorProfileRepository.save(profile);
    }

    @Transactional
    public DonorProfile toggleAvailability(User user) {

        // Profile dhundho
        DonorProfile profile = donorProfileRepository
                .findByUser(user)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Profile doesn't exists!"));

        // Toggle karo — true tha toh false, false tha toh true
        profile.setAvailable(!profile.isAvailable());

        return donorProfileRepository.save(profile);
    }
    // Search
    public List<DonorProfile> searchDonors(
            String city, String bloodGroup) {

        List<DonorProfile> result = donorProfileRepository
                .findByCityAndBloodGroupAndAvailableTrue(city, bloodGroup);
        return result;
    }
    public DonorProfile getMyProfile(User user) {
        return donorProfileRepository
                .findByUser(user)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Profile doesn't exist!"));
    }
}


