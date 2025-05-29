package com.eventsapp.backend.factory;

import com.eventsapp.backend.model.Booking;
import com.eventsapp.backend.model.Event;

/**
 * Factory interface for creating {@link Event} objects.
 * <p>
 * Implementations of this interface are responsible for generating
 * event instances based on booking information or other criteria.
 */
public interface EventFactory {

    /**
     * Creates a new {@link Event} instance using the provided {@link Booking} details.
     *
     * @param booking the booking information used to initialize the event
     * @return a new {@link Event} instance initialized with booking data
     */
    Event createEventFromBooking(Booking booking);
}
