package com.eventsapp.backend.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) used for creating a booking.
 * <p>
 * This object is used by clients when submitting a request to book a venue.
 */
@Data
public class BookingRequest {

    /**
     * The ID of the venue to be booked.
     */
    private int venueId;

    /**
     * The date of the event to be booked.
     */
    private LocalDate eventDate;

    /**
     * The estimated number of guests expected to attend the event.
     */
    private int estimatedGuestCount;

    /**
     * The amount paid by the client for the booking.
     */
    private int paidSum;
}
