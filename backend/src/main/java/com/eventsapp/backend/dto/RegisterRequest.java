package com.eventsapp.backend.dto;

import com.eventsapp.backend.model.enums.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}