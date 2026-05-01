package com.bloodbridge.blood_bridge.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}