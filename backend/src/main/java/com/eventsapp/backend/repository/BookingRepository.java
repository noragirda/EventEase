package com.eventsapp.backend.repository;

import com.eventsapp.backend.model.Booking;
import com.eventsapp.backend.model.Venue;
import com.eventsapp.backend.model.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for {@link Booking} entities.
 * Provides CRUD operations and custom query methods related to bookings.
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {

    /**
     * Finds all bookings with the specified booking status.
     *
     * @param status the booking status to filter by
     * @return a list of bookings matching the given status
     */
    List<Booking> findByBookingStatus(BookingStatus status);

    /**
     * Finds all bookings for a given venue.
     *
     * @param venue the venue entity to filter bookings by
     * @return a list of bookings associated with the given venue
     */
    List<Booking> findByVenueId(Venue venue);

    /**
     * Finds all bookings that do not have the specified booking status.
     *
     * @param status the booking status to exclude
     * @return a list of bookings with statuses different from the given status
     */
    List<Booking> findByBookingStatusNot(BookingStatus status);
}
