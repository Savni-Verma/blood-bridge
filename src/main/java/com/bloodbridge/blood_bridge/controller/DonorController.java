package com.bloodbridge.blood_bridge.controller;

import com.bloodbridge.blood_bridge.dto.DonorProfileRequest;
import com.bloodbridge.blood_bridge.model.DonorProfile;
import com.bloodbridge.blood_bridge.model.User;
import com.bloodbridge.blood_bridge.service.DonorService;
import com.bloodbridge.blood_bridge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donors")
@RequiredArgsConstructor
public class DonorController {

    private final DonorService donorService;
    private final UserService userService;

    // Token se current user nikalo
    private User getCurrentUser(Authentication auth) {
        return userService.getCurrentUser(auth.getName());
    }

    // Profile banao / update karo
    @PostMapping("/profile")
    public ResponseEntity<DonorProfile> saveProfile(
            Authentication auth,
            @RequestBody DonorProfileRequest request) {

        User user = getCurrentUser(auth);
        DonorProfile profile = donorService.saveProfile(
                user,
                request.getBloodGroup(),
                request.getCity(),
                request.getLastDonationDate());

        return ResponseEntity.ok(profile);
    }

    // Apna profile dekho
    @GetMapping("/profile")
    public ResponseEntity<DonorProfile> getMyProfile(
            Authentication auth) {

        User user = getCurrentUser(auth);
        return ResponseEntity.ok(donorService.getMyProfile(user));
    }

    // Availability toggle karo
    @PatchMapping("/availability")
    public ResponseEntity<DonorProfile> toggleAvailability(
            Authentication auth) {

        User user = getCurrentUser(auth);
        return ResponseEntity.ok(donorService.toggleAvailability(user));
    }

    // Donors search karo
    @GetMapping("/search")
    public ResponseEntity<List<DonorProfile>> searchDonors(
            @RequestParam String city,
            @RequestParam String bloodGroup) {

        return ResponseEntity.ok(
                donorService.searchDonors(city, bloodGroup));
    }
}