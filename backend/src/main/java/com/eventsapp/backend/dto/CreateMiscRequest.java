package com.eventsapp.backend.dto;

import lombok.Data;

/**
 * DTO used by clients to create or update the miscellaneous settings for their event.
 * <p>
 * Includes decorative and service-related preferences such as napkin color, decorations,
 * and service providers for music, cake, and candy.
 */
@Data
public class CreateMiscRequest {

    /**
     * The selected napkin color for the event.
     */
    private String napkinsColors;

    /**
     * Indicates if flower decorations are requested.
     */
    private boolean flowerDecoration;

    /**
     * Indicates if a candy bar should be included.
     */
    private boolean candyBar;

    /**
     * Indicates if a photo corner should be set up.
     */
    private boolean photoCorner;

    /**
     * Name or description of the selected music provider.
     */
    private String musicProvider;

    /**
     * Name or description of the selected cake provider.
     */
    private String cakeProvider;

    /**
     * Name or description of the selected candy provider.
     */
    private String candyProvider;
}
