package com.bloodbridge.blood_bridge.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    String name;
    String email;
    String password;
    private String phoneNumber;
}
