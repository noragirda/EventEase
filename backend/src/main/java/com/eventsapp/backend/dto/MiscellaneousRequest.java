package com.eventsapp.backend.dto;

import com.eventsapp.backend.model.enums.NapkinsColors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiscellaneousRequest {
    private NapkinsColors napkinsColors;
    private boolean flowerDecoration;
    private boolean candyBar;
    private boolean photoCorner;
    private String musicProvider;
    private String cakeProvider;
    private String candyProvider;
}
