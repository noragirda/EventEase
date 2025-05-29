package com.eventsapp.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for the application.
 * <p>
 * This class intercepts specific exceptions thrown across the application and returns
 * standardized HTTP responses with appropriate status codes and messages.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles exceptions when an uploaded file exceeds the maximum allowed size.
     *
     * @param exc the thrown {@link MaxUploadSizeExceededException}
     * @return a response entity with HTTP 413 (Payload Too Large) and a user-friendly message
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<String> handleMaxSizeException(MaxUploadSizeExceededException exc) {
        return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE)
                .body("File too large! Please upload a smaller image.");
    }
}
