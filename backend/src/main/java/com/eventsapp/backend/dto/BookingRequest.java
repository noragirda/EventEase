package com.eventsapp.backend.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequest {
    private int venueId;
    private LocalDate eventDate;
    private int estimatedGuestCount;
    private int paidSum;
}
