package com.eventsapp.backend.factory;

import com.eventsapp.backend.model.Miscellaneous;
import com.eventsapp.backend.model.enums.NapkinsColors;

/**
 * Factory interface for creating {@link Miscellaneous} objects.
 * <p>
 * This interface defines the contract for building miscellaneous customization
 * options associated with an event, such as decorations, providers, and accessories.
 */
public interface MiscellaneousFactory {

    /**
     * Creates a {@link Miscellaneous} object using the specified customization options.
     *
     * @param napkinsColors      the selected {@link NapkinsColors} enum value
     * @param flowerDecoration   whether flower decoration is included
     * @param candyBar           whether a candy bar is included
     * @param photoCorner        whether a photo corner is included
     * @param musicProvider      the name of the music provider
     * @param cakeProvider       the name of the cake provider
     * @param candyProvider      the name of the candy provider
     * @return a fully constructed {@link Miscellaneous} object
     */
    Miscellaneous createMiscellaneous(
            NapkinsColors napkinsColors,
            boolean flowerDecoration,
            boolean candyBar,
            boolean photoCorner,
            String musicProvider,
            String cakeProvider,
            String candyProvider
    );
}
