package com.eventsapp.backend.exception;

/**
 * Exception thrown when a specific resource cannot be found.
 * <p>
 * This is typically used in service or controller layers to indicate
 * that an entity or resource referenced by an identifier does not exist.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructs a new {@code ResourceNotFoundException} with the specified detail message.
     *
     * @param message the detail message describing the missing resource
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
