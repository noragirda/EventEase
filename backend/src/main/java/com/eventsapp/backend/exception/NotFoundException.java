package com.eventsapp.backend.exception;

/**
 * Custom exception thrown when a requested resource is not found.
 * <p>
 * Typically used in service or controller layers to signal missing entities.
 */
public class NotFoundException extends RuntimeException {

    /**
     * Constructs a new {@code NotFoundException} with the specified detail message.
     *
     * @param message the detail message explaining what was not found
     */
    public NotFoundException(String message) {
        super(message);
    }
}
