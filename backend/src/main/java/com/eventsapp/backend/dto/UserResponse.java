package com.eventsapp.backend.dto;

import lombok.*;

/**
 * Data Transfer Object used to return user information in responses.
 * <p>
 * This class is typically used to send user data to the frontend, including
 * basic identity and role-related information.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    /** Unique identifier of the user. */
    private Long id;

    /** Full name of the user. */
    private String name;

    /** Email address of the user. */
    private String email;

    /** Role of the user (e.g., ADMIN, CLIENT, REFEREE). */
    private String role;
}
