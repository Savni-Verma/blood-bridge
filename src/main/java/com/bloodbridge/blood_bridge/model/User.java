package com.bloodbridge.blood_bridge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "users", indexes = {
        @Index(name = "idx_email", columnList = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Column(unique=true,nullable = false)
    String email;

    @JsonIgnore
    @Column(nullable=false)
    String password;

    private String phoneNumber;

}
