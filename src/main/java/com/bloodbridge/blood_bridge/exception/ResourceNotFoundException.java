package com.bloodbridge.blood_bridge.exception;

// RuntimeException extend karni hai
// Kyunki yeh bhi ek runtime error hai
public class ResourceNotFoundException extends RuntimeException {

    // Constructor — message lega
    public ResourceNotFoundException(String message) {
        super(message); // Parent ko message do
    }
}
