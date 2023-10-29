package com.pss.error;

public class InstanceNotFoundException extends RuntimeException {
    public InstanceNotFoundException(String message) {
        super(message);
    }
}
