package com.eventsapp.backend.controller;

import com.eventsapp.backend.dto.VenueResponse;
import com.eventsapp.backend.dto.VenueResponseBooking;
import com.eventsapp.backend.service.impl.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientVenueController {

    private final VenueService venueService;

    @GetMapping("/venues-with-events")
    public List<VenueResponseBooking> getVenuesWithBookedDates() {
        return venueService.getVenuesWithBookedDates();
    }
}
