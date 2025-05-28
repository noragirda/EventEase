package com.eventsapp.backend.mapper;

import com.eventsapp.backend.dto.VenueResponse;
import com.eventsapp.backend.model.Venue;

public class VenueMapper {
    public static VenueResponse toDto(Venue venue) {
        return new VenueResponse(
                venue.getId(),
                venue.getName(),
                venue.getDescription(),
                venue.getGuestCapacity(),
                venue.getProviding(),
                venue.getImageUrl()
        );
    }
}
