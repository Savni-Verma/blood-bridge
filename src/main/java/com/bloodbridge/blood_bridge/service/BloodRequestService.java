package com.bloodbridge.blood_bridge.service;

import com.bloodbridge.blood_bridge.exception.ResourceNotFoundException;
import com.bloodbridge.blood_bridge.model.BloodRequest;
import com.bloodbridge.blood_bridge.model.User;
import com.bloodbridge.blood_bridge.repository.BloodRequestRepository;
import com.bloodbridge.blood_bridge.repository.DonorProfileRepository;
import com.bloodbridge.blood_bridge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BloodRequestService {

    private final BloodRequestRepository bloodRequestRepository;
    private final UserRepository userRepository;
    private final DonorProfileRepository donorProfileRepository;

    @Transactional
    public BloodRequest sendRequest(User seeker, User donor,String bloodGroup,
                                    String city,boolean urgent){

        BloodRequest request = new BloodRequest();

        request.setSeeker(seeker);
        request.setDonor(donor);
        request.setBloodGroup(bloodGroup);
        request.setCity(city);
        request.setUrgent(urgent);

        return bloodRequestRepository.save(request);
    }

    public List<BloodRequest> getMySentRequests(User seeker) {
       return bloodRequestRepository.findBySeeker(seeker);
    }

    public List<BloodRequest> getMyReceivedRequests(User donor) {
       return bloodRequestRepository.findByDonor(donor);
    }

    @Transactional
    public BloodRequest updateStatus(Long requestId,
                                     BloodRequest.RequestStatus status) {
        BloodRequest request = bloodRequestRepository
                .findById(requestId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Request doesn't found!"));

        request.setStatus(status);

        return bloodRequestRepository.save(request);
    }
}
