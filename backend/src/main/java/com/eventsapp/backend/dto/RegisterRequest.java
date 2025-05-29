package com.eventsapp.backend.dto;

import com.eventsapp.backend.model.enums.Role;
import lombok.Data;

/**
 * Data Transfer Object for handling user registration requests.
 * <p>
 * This class carries user details required during the registration process, such as name,
 * email, password, and user role (e.g., CLIENT, ADMIN).
 */
@Data
public class RegisterRequest {

    /** The full name of the user registering. */
    private String name;

    /** The email address used for authentication and communication. */
    private String email;

    /** The password used for user authentication. */
    private String password;

    /** The role assigned to the user (e.g., CLIENT, ADMIN). */
    private Role role;
}
