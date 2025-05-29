package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.dto.UserResponse;

import java.util.List;

/**
 * Service interface for managing users.
 */
public interface UserService {

    /**
     * Retrieves all users in the system.
     *
     * @return list of all users represented as {@link UserResponse} DTOs
     */
    List<UserResponse> getAllUsers();

    /**
     * Deletes a user by their ID.
     *
     * @param userId the ID of the user to delete
     */
    void deleteUser(Long userId);
}
