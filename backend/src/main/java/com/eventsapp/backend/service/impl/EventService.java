package com.eventsapp.backend.service.impl;


import com.eventsapp.backend.dto.*;

import java.util.List;

public interface EventService {
    void updateClientEvent(Long eventId, String clientEmail, EventUpdateRequest request);
    void assignCustomMenu(Long eventId, CreateMenuRequest request);
    void assignCustomMisc(Long eventId, CreateMiscRequest request);
    void assignMiscellaneousToEvent(Long eventId, MiscellaneousRequest request);
    void updateMiscellaneous(Long eventId, MiscellaneousRequest request);
    List<VenueWithEventsResponse> getVenuesWithEventsByAdminEmail(String email);
    void updateEventPrices(Long eventId, AdminEventPriceUpdateRequest request);
    FullEventDetailsResponse getFullEventDetails(Long eventId);

}
