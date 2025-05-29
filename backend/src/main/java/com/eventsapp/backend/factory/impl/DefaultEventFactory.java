package com.eventsapp.backend.factory.impl;

import com.eventsapp.backend.factory.EventFactory;
import com.eventsapp.backend.model.Booking;
import com.eventsapp.backend.model.Event;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * Default implementation of the {@link EventFactory} interface.
 * <p>
 * Responsible for creating an {@link Event} instance from a given {@link Booking}.
 * This implementation initializes default values for optional fields and assigns
 * booking-related fields such as venue, date, and guest count.
 */
@Component
public class DefaultEventFactory implements EventFactory {

    /**
     * Creates a new {@link Event} object based on the provided {@link Booking}.
     * Sets default values for pricing, dietary preferences, and uninitialized components.
     *
     * @param booking the booking from which to create the event
     * @return a newly constructed Event instance with fields initialized from the booking
     */
    @Override
    public Event createEventFromBooking(Booking booking) {
        Event event = new Event();
        event.setVenue(booking.getVenueId());
        event.setEventDate(booking.getEventDate());
        event.setFinalAdultCount(booking.getEstimatedGuestCount());
        event.setClientIds(Collections.singletonList(booking.getClientId()));
        event.setStartingTime(booking.getStartingTime());

        // Initialize default values
        event.setCalculatedPricePerAdult(0);
        event.setCalculatedPricePerChild(0);
        event.setVegetarians(0);
        event.setVegans(0);
        event.setDrinks(null);
        event.setMenu(null);
        event.setMiscellaneous(null);
        event.setFruits(null);
        event.setEventType(null);

        return event;
    }
}
