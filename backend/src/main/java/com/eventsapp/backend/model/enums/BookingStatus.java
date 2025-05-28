package com.eventsapp.backend.model.enums;

public enum BookingStatus {
    PENDING, // Awaiting payment
    AWAITING_APPROVAL, // Paid, waiting for admin confirmation
    CONFIRMED,
    REJECTED
}