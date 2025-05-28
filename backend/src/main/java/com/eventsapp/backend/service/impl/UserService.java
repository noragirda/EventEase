package com.eventsapp.backend.service.impl;


import com.eventsapp.backend.dto.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();
    void deleteUser(Long userId);
}