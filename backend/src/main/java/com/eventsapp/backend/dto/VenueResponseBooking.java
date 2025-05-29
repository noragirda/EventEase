package com.eventsapp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * Data Transfer Object used to represent a venue along with its booked dates.
 * <p>
 * This DTO is typically used when clients need to view which dates are unavailable
 * for booking at a particular venue.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenueResponseBooking {

    /** Unique identifier of the venue. */
    private int id;

    /** Name of the venue. */
    private String name;

    /** Description of the venue including location or services. */
    private String description;

    /** Maximum number of guests the venue can host. */
    private int guestCapacity;

    /** List of dates when the venue is already booked. */
    private List<LocalDate> bookedDates;
}
