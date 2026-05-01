package com.bloodbridge.blood_bridge.controller;

import com.bloodbridge.blood_bridge.dto.BloodRequestDto;
import com.bloodbridge.blood_bridge.model.BloodRequest;
import com.bloodbridge.blood_bridge.model.User;
import com.bloodbridge.blood_bridge.service.BloodRequestService;
import com.bloodbridge.blood_bridge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor
public class BloodRequestController {

    private final BloodRequestService bloodRequestService;
    private final UserService userService;

    private User getCurrentUser(Authentication auth) {
        return userService.getCurrentUser(auth.getName());
    }

    // Request bhejo
    @PostMapping
    public ResponseEntity<BloodRequest> sendRequest(
            Authentication auth,
            @RequestBody BloodRequestDto request) {

        User seeker = getCurrentUser(auth);
        User donor = userService.findByEmail(request.getDonorEmail());

        BloodRequest bloodRequest = bloodRequestService.sendRequest(
                seeker,
                donor,
                request.getBloodGroup(),
                request.getCity(),
                request.isUrgent());

        return ResponseEntity.ok(bloodRequest);
    }

    // Sent requests dekho
    @GetMapping("/sent")
    public ResponseEntity<List<BloodRequest>> getMySentRequests(
            Authentication auth) {

        User seeker = getCurrentUser(auth);
        return ResponseEntity.ok(
                bloodRequestService.getMySentRequests(seeker));
    }

    // Received requests dekho
    @GetMapping("/received")
    public ResponseEntity<List<BloodRequest>> getMyReceivedRequests(
            Authentication auth) {

        User donor = getCurrentUser(auth);
        return ResponseEntity.ok(
                bloodRequestService.getMyReceivedRequests(donor));
    }

    // Status update karo
    @PatchMapping("/{id}/status")
    public ResponseEntity<BloodRequest> updateStatus(
            @PathVariable Long id,
            @RequestParam BloodRequest.RequestStatus status) {

        return ResponseEntity.ok(
                bloodRequestService.updateStatus(id, status));
    }
}