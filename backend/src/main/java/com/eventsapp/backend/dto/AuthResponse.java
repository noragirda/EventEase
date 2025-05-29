package com.eventsapp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Response object returned after a successful authentication (login or registration).
 * <p>
 * Contains the JWT token to be used for authenticated requests.
 */
@Data
@AllArgsConstructor
public class AuthResponse {

    /**
     * The JWT token issued upon successful authentication.
     */
    private String token;
}
