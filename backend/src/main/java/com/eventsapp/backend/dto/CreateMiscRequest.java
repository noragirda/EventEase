package com.eventsapp.backend.dto;

import lombok.Data;

@Data
public class CreateMiscRequest {
    private String napkinsColors;
    private boolean flowerDecoration;
    private boolean candyBar;
    private boolean photoCorner;
    private String musicProvider;
    private String cakeProvider;
    private String candyProvider;
}