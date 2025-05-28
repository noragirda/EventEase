package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.dto.UserResponse;
import com.eventsapp.backend.dto.VenueRequest;
import com.eventsapp.backend.dto.VenueResponse;
import com.eventsapp.backend.dto.VenueResponseBooking;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VenueService {
    List<VenueResponse> getAllVenues();
    VenueResponse createVenue(VenueRequest request, MultipartFile image);
    VenueResponse updateVenue(int id, VenueRequest request, MultipartFile image);
    public List<UserResponse> getAvailableAdminsForVenue(int venueId);
    public void assignAdminsToVenue(int venueId, List<Long> adminIds);
    List<VenueResponseBooking> getVenuesWithBookedDates();
    List<VenueResponse> getVenuesForAdmin(String adminEmail);

}