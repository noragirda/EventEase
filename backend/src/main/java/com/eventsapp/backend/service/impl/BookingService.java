package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.dto.BookingRequest;

/**
 * Service interface defining operations related to managing bookings.
 */
public interface BookingService {

    /**
     * Creates a new booking for the client identified by email.
     *
     * @param request the booking request containing booking details
     * @param clientEmail the email of the client making the booking
     */
    void createBooking(BookingRequest request, String clientEmail);

    /**
     * Approves a booking by its ID.
     * Typically updates booking status and creates a related event.
     *
     * @param bookingId the ID of the booking to approve
     */
    void approveBooking(Long bookingId);

    /**
     * Marks a booking as paid by its ID.
     *
     * @param bookingId the ID of the booking to mark as paid
     */
    void markBookingAsPaid(Long bookingId);

    /**
     * Rejects a booking by its ID.
     *
     * @param bookingId the ID of the booking to reject
     */
    void rejectBooking(Long bookingId);
}
