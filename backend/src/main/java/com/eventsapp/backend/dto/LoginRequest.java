package com.eventsapp.backend.dto;

import lombok.Data;

/**
 * DTO representing a login request.
 * <p>
 * This object is used to capture the login credentials submitted by a user.
 */
@Data
public class LoginRequest {

    /** The user's email address used for login. */
    private String email;

    /** The user's password used for authentication. */
    private String password;
}
