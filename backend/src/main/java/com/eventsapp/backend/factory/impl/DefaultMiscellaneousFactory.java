package com.eventsapp.backend.factory.impl;

import com.eventsapp.backend.builder.MiscellaneousBuilder;
import com.eventsapp.backend.factory.MiscellaneousFactory;
import com.eventsapp.backend.model.Miscellaneous;
import com.eventsapp.backend.model.enums.NapkinsColors;
import org.springframework.stereotype.Component;

/**
 * Default implementation of the {@link MiscellaneousFactory} interface.
 * <p>
 * Constructs {@link Miscellaneous} objects using the {@link MiscellaneousBuilder}.
 */
@Component
public class DefaultMiscellaneousFactory implements MiscellaneousFactory {

    /**
     * Creates a customized {@link Miscellaneous} object based on the provided parameters.
     * Utilizes the {@link MiscellaneousBuilder} for object construction.
     *
     * @param napkinsColors     the color of the napkins selected
     * @param flowerDecoration  whether flower decoration is included
     * @param candyBar          whether a candy bar is included
     * @param photoCorner       whether a photo corner is included
     * @param musicProvider     the name of the music provider
     * @param cakeProvider      the name of the cake provider
     * @param candyProvider     the name of the candy provider
     * @return a fully constructed {@link Miscellaneous} object
     */
    @Override
    public Miscellaneous createMiscellaneous(
            NapkinsColors napkinsColors,
            boolean flowerDecoration,
            boolean candyBar,
            boolean photoCorner,
            String musicProvider,
            String cakeProvider,
            String candyProvider
    ) {
        return MiscellaneousBuilder.builder()
                .withNapkinsColor(napkinsColors)
                .withFlowerDecoration(flowerDecoration)
                .withCandyBar(candyBar)
                .withPhotoCorner(photoCorner)
                .withMusicProvider(musicProvider)
                .withCakeProvider(cakeProvider)
                .withCandyProvider(candyProvider)
                .build();
    }

}
