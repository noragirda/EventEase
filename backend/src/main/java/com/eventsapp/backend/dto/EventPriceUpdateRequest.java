package com.eventsapp.backend.dto;

import lombok.Data;

/**
 * Data Transfer Object (DTO) for updating the event pricing details.
 * <p>
 * This is typically used when an admin or system logic modifies the
 * calculated price per adult or per child for an event.
 */
@Data
public class EventPriceUpdateRequest {

    /**
     * The calculated price to be charged per adult for the event.
     */
    private int calculatedPricePerAdult;

    /**
     * The calculated price to be charged per child for the event.
     */
    private int calculatedPricePerChild;
}
