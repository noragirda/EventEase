package com.eventsapp.backend.dto;

import lombok.Data;

/**
 * Data Transfer Object (DTO) used to update the calculated price fields
 * of an event by an admin.
 * <p>
 * This object carries the new prices per adult and per child to the backend.
 */
@Data
public class AdminEventPriceUpdateRequest {

    /**
     * The new calculated price per adult for the event.
     */
    private int calculatedPricePerAdult;

    /**
     * The new calculated price per child for the event.
     */
    private int calculatedPricePerChild;
}
