package com.eventsapp.backend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueRequest {
    private String name;
    private String description;
    private int guestCapacity;
    private String providing;
}
