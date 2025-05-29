package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.dto.UserResponse;
import com.eventsapp.backend.dto.VenueRequest;
import com.eventsapp.backend.dto.VenueResponse;
import com.eventsapp.backend.dto.VenueResponseBooking;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Service interface for managing Venue-related operations.
 */
public interface VenueService {

    /**
     * Retrieves all venues.
     *
     * @return a list of venue responses representing all venues
     */
    List<VenueResponse> getAllVenues();

    /**
     * Creates a new venue with optional image upload.
     *
     * @param request the data for creating the venue
     * @param image   the optional image file for the venue
     * @return the created venue response
     */
    VenueResponse createVenue(VenueRequest request, MultipartFile image);

    /**
     * Updates an existing venue by ID with optional image upload.
     *
     * @param id      the ID of the venue to update
     * @param request the data to update the venue
     * @param image   the optional image file for the venue
     * @return the updated venue response
     */
    VenueResponse updateVenue(int id, VenueRequest request, MultipartFile image);

    /**
     * Retrieves a list of available admins for a specific venue.
     *
     * @param venueId the ID of the venue
     * @return a list of user responses representing available admins
     */
    List<UserResponse> getAvailableAdminsForVenue(int venueId);

    /**
     * Assigns a list of admins to a specific venue.
     *
     * @param venueId  the ID of the venue
     * @param adminIds the list of admin IDs to assign
     */
    void assignAdminsToVenue(int venueId, List<Long> adminIds);

    /**
     * Retrieves all venues along with their booked dates.
     *
     * @return a list of venue responses with booking dates
     */
    List<VenueResponseBooking> getVenuesWithBookedDates();

    /**
     * Retrieves all venues managed by a specific admin.
     *
     * @param adminEmail the email of the admin
     * @return a list of venue responses for venues managed by the admin
     */
    List<VenueResponse> getVenuesForAdmin(String adminEmail);
}
