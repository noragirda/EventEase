package com.eventsapp.backend.model.enums;

/**
 * Enum representing the status of a booking.
 */
public enum BookingStatus {

    /**
     * Booking is created but payment has not yet been made.
     */
    PENDING,

    /**
     * Payment has been made, but admin approval is still pending.
     */
    AWAITING_APPROVAL,

    /**
     * Booking is confirmed by the admin.
     */
    CONFIRMED,

    /**
     * Booking has been rejected by the admin.
     */
    REJECTED
}
