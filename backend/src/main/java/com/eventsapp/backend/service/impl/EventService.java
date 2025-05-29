package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.dto.*;

import java.util.List;

/**
 * Service interface defining operations related to events.
 */
public interface EventService {

    /**
     * Updates event details for a client, verifying client ownership.
     *
     * @param eventId     the ID of the event to update
     * @param clientEmail the email of the client requesting the update
     * @param request     the update request data
     */
    void updateClientEvent(Long eventId, String clientEmail, EventUpdateRequest request);

    /**
     * Assigns a custom menu to an event.
     *
     * @param eventId the ID of the event
     * @param request the custom menu creation request
     */
    void assignCustomMenu(Long eventId, CreateMenuRequest request);

    /**
     * Assigns custom miscellaneous options to an event.
     *
     * @param eventId the ID of the event
     * @param request the custom miscellaneous creation request
     */
    void assignCustomMisc(Long eventId, CreateMiscRequest request);

    /**
     * Assigns miscellaneous settings to an event.
     *
     * @param eventId the ID of the event
     * @param request the miscellaneous request data
     */
    void assignMiscellaneousToEvent(Long eventId, MiscellaneousRequest request);

    /**
     * Updates miscellaneous details for an event.
     *
     * @param eventId the ID of the event
     * @param request the miscellaneous update request
     */
    void updateMiscellaneous(Long eventId, MiscellaneousRequest request);

    /**
     * Retrieves venues with their events managed by a specific admin identified by email.
     *
     * @param email the admin's email
     * @return a list of venues with events
     */
    List<VenueWithEventsResponse> getVenuesWithEventsByAdminEmail(String email);

    /**
     * Updates price-related fields of an event.
     *
     * @param eventId the ID of the event
     * @param request the price update request
     */
    void updateEventPrices(Long eventId, AdminEventPriceUpdateRequest request);

    /**
     * Retrieves full details of an event.
     *
     * @param eventId the ID of the event
     * @return a response DTO containing full event details
     */
    FullEventDetailsResponse getFullEventDetails(Long eventId);
}
