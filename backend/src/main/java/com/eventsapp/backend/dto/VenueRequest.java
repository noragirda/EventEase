package com.eventsapp.backend.dto;

import lombok.*;

/**
 * Data Transfer Object used to encapsulate data for creating or updating a Venue.
 * <p>
 * This class is typically received from the frontend when an admin adds or edits a venue.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueRequest {

    /** Name of the venue. */
    private String name;

    /** Description or additional details about the venue. */
    private String description;

    /** Maximum number of guests the venue can accommodate. */
    private int guestCapacity;

    /** Services or amenities provided by the venue. */
    private String providing;
}
