package com.eventsapp.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) for returning summary information about an event.
 * <p>
 * This is used to provide clients or administrators with essential details of a booked event.
 */
@Data
public class EventResponse {

    /**
     * The unique identifier of the event.
     */
    private Long id;

    /**
     * The starting date and time of the event.
     */
    private LocalDateTime startingTime;

    /**
     * The final confirmed number of adult guests attending the event.
     */
    private int finalAdultCount;

    /**
     * The calculated price per adult guest.
     */
    private int calculatedPricePerAdult;

    /**
     * The calculated price per child guest.
     */
    private int calculatedPricePerChild;
}
