package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.dto.BookingRequest;

public interface BookingService {
    void createBooking(BookingRequest request, String clientEmail);
    void approveBooking(Long bookingId);
    void markBookingAsPaid(Long bookingId);
    public void rejectBooking(Long bookingId);
}
