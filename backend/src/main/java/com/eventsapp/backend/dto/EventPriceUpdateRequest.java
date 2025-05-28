package com.eventsapp.backend.dto;

import lombok.Data;

@Data
public class EventPriceUpdateRequest {
    private int calculatedPricePerAdult;
    private int calculatedPricePerChild;
}