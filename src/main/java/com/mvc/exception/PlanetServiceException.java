package com.mvc.exception;

public class PlanetServiceException extends RuntimeException {
    public PlanetServiceException(String message) {
        super(message);
    }
}
