package com.eventsapp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenueResponseBooking {
    private int id;
    private String name;
    private String description;
    private int guestCapacity;
    private List<LocalDate> bookedDates; // ✅ This is computed from Booking table
}
