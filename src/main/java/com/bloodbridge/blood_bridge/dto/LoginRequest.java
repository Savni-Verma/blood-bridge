package com.bloodbridge.blood_bridge.dto;

import lombok.Data;

@Data
public class LoginRequest {
    String email;
    String password;
}
