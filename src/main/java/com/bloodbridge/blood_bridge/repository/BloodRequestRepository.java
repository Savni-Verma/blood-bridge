package com.bloodbridge.blood_bridge.repository;

import com.bloodbridge.blood_bridge.model.BloodRequest;
import com.bloodbridge.blood_bridge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BloodRequestRepository extends JpaRepository<BloodRequest,Long> {
    List<BloodRequest> findBySeeker(User seeker);

    List<BloodRequest> findByDonor(User donor);
}
