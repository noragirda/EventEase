package com.eventsapp.backend.dto;

import lombok.Data;
import java.util.List;

@Data
public class VenueWithEventsResponse {
    private int venueId;
    private String name;
    private String imageUrl;
    private List<EventResponse> events;
}
