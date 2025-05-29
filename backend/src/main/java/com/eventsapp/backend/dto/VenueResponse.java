package com.eventsapp.backend.dto;

import lombok.*;

/**
 * Data Transfer Object used to represent venue information returned to the client.
 * <p>
 * This is typically used in responses when fetching a list of venues or viewing venue details.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueResponse {

    /** Unique identifier of the venue. */
    private int id;

    /** Name of the venue. */
    private String name;

    /** Description or additional details about the venue. */
    private String description;

    /** Maximum number of guests the venue can accommodate. */
    private int guestCapacity;

    /** Services or amenities provided by the venue. */
    private String providing;

    /** URL of the image representing the venue. */
    private String imageUrl;
}
