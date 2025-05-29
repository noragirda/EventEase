package com.eventsapp.backend.dto;

import lombok.Data;
import java.util.List;

/**
 * Data Transfer Object representing a venue along with the list of associated events.
 * <p>
 * This DTO is used to display all events scheduled at a specific venue,
 * often for admin or client-side viewing.
 */
@Data
public class VenueWithEventsResponse {

    /** Unique identifier of the venue. */
    private int venueId;

    /** Name of the venue. */
    private String name;

    /** URL pointing to the image representing the venue. */
    private String imageUrl;

    /** List of events associated with the venue. */
    private List<EventResponse> events;
}
