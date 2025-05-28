package com.eventsapp.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EventResponse {
    private Long id;
    private LocalDateTime startingTime;
    private int finalAdultCount;
    private int calculatedPricePerAdult;
    private int calculatedPricePerChild;
}
