package com.bloodbridge.blood_bridge.dto;

import lombok.Data;

@Data
public class BloodRequestDto {
    String bloodGroup;
    String city;
    boolean urgent;
    String donorEmail;
}
