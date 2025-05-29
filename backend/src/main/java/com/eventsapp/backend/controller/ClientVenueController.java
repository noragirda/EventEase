package com.eventsapp.backend.controller;

import com.eventsapp.backend.dto.VenueResponseBooking;
import com.eventsapp.backend.service.impl.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for client-side venue exploration.
 * Allows clients to view available venues along with their already booked dates.
 */
@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientVenueController {

    /**
     * Service for handling venue-related logic.
     */
    private final VenueService venueService;

    /**
     * Retrieves a list of venues with their corresponding booked event dates.
     * This allows clients to check availability before booking.
     *
     * @return a list of {@link VenueResponseBooking} objects, each including venue info and booked dates
     */
    @GetMapping("/venues-with-events")
    public List<VenueResponseBooking> getVenuesWithBookedDates() {
        return venueService.getVenuesWithBookedDates();
    }
}
