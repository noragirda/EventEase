package com.eventsapp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApetizerDTO {
    private int id;
    private String name;
    private int maxNumberOfPieces;
}
