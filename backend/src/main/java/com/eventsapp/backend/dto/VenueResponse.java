package com.eventsapp.backend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueResponse {
    private int id;
    private String name;
    private String description;
    private int guestCapacity;
    private String providing;
    private String imageUrl;
}
