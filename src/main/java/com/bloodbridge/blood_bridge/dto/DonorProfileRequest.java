package com.bloodbridge.blood_bridge.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DonorProfileRequest {
    String bloodGroup;
    String city;
    LocalDate lastDonationDate;

}
