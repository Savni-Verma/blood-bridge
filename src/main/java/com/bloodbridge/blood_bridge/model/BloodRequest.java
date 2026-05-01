package com.bloodbridge.blood_bridge.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
public class BloodRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "seeker_id")
    private User seeker;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private User donor;

    String bloodGroup;
    String city;
    boolean urgent;
   private LocalDateTime createdAt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private RequestStatus status = RequestStatus.PENDING;

    public enum RequestStatus {
        PENDING, ACCEPTED, REJECTED, COMPLETED
    }
}
