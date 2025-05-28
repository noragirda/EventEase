package com.eventsapp.backend.repository;

import com.eventsapp.backend.model.Booking;
import com.eventsapp.backend.model.Venue;
import com.eventsapp.backend.model.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByBookingStatus(BookingStatus status);
    List<Booking> findByVenueId(Venue venue);
    List<Booking> findByBookingStatusNot(BookingStatus status);

}
