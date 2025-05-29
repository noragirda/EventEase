package com.eventsapp.backend.model.enums;

/**
 * Enum representing the status of a payment made for an event booking.
 */
public enum PaymentStatus {

    /** Payment has not yet been completed by the client. */
    PENDING,

    /** Payment has been successfully completed. */
    PAID,

    /** Payment attempt failed due to an error or rejection. */
    FAILED
}
