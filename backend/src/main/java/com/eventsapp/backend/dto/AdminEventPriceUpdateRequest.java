package com.eventsapp.backend.dto;

import lombok.Data;

@Data
public class AdminEventPriceUpdateRequest {
    private int calculatedPricePerAdult;
    private int calculatedPricePerChild;
}
