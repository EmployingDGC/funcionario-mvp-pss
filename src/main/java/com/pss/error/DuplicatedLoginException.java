package com.pss.error;

public class DuplicatedLoginException extends RuntimeException {
    public DuplicatedLoginException(String message) {
        super(message);
    }
}
