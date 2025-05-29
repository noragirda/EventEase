package com.eventsapp.backend.dto;

import com.eventsapp.backend.model.enums.NapkinsColors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object used to encapsulate miscellaneous event settings.
 * <p>
 * This class is used to transfer additional customization options related to the event's decorations,
 * entertainment, and food services from the client to the backend.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiscellaneousRequest {

    /** The selected color for the napkins. */
    private NapkinsColors napkinsColors;

    /** Whether the event includes flower decoration. */
    private boolean flowerDecoration;

    /** Whether the event includes a candy bar. */
    private boolean candyBar;

    /** Whether the event includes a photo corner. */
    private boolean photoCorner;

    /** The name of the music provider or band/DJ for the event. */
    private String musicProvider;

    /** The name of the cake provider for the event. */
    private String cakeProvider;

    /** The name of the candy provider for the event. */
    private String candyProvider;
}
