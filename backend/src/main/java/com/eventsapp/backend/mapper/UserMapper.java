package com.eventsapp.backend.mapper;

import com.eventsapp.backend.dto.UserResponse;
import com.eventsapp.backend.model.User;

/**
 * Utility class for mapping User entity objects to UserResponse DTOs.
 */
public class UserMapper {

    /**
     * Converts a User entity to a UserResponse DTO.
     *
     * @param user the User entity to convert
     * @return the corresponding UserResponse DTO
     */
    public static UserResponse toDto(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().name()
        );
    }
}
