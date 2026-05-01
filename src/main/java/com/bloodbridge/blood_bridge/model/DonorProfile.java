package com.bloodbridge.blood_bridge.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class DonorProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    String bloodGroup;
    String city;

    boolean available = true;

    LocalDate lastDonationDate;


}
