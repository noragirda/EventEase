package com.eventsapp.backend.mapper;

import com.eventsapp.backend.dto.UserResponse;
import com.eventsapp.backend.model.User;

public class UserMapper {

    public static UserResponse toDto(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().name()
        );
    }
}
