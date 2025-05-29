package com.eventsapp.backend.mapper;

import com.eventsapp.backend.dto.VenueResponse;
import com.eventsapp.backend.model.Venue;

/**
 * Utility class for converting Venue entities to VenueResponse DTOs.
 */
public class VenueMapper {

    /**
     * Converts a Venue entity to a VenueResponse DTO.
     *
     * @param venue the Venue entity to convert
     * @return the corresponding VenueResponse DTO
     */
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
