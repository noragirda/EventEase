package com.eventsapp.backend.builder;

import com.eventsapp.backend.model.Miscellaneous;
import com.eventsapp.backend.model.enums.NapkinsColors;

/**
 * Builder class for constructing {@link Miscellaneous} objects in a readable and fluent manner.
 * This is used to create the additional customizable options for an event, such as decorations and service providers.
 */
public class MiscellaneousBuilder {

    /**
     * The selected napkin color.
     */
    private NapkinsColors napkinsColors;

    /**
     * Whether flower decoration is included.
     */
    private boolean flowerDecoration;

    /**
     * Whether a candy bar is included.
     */
    private boolean candyBar;

    /**
     * Whether a photo corner is included.
     */
    private boolean photoCorner;

    /**
     * The music provider's name.
     */
    private String musicProvider;

    /**
     * The cake provider's name.
     */
    private String cakeProvider;

    /**
     * The candy provider's name.
     */
    private String candyProvider;

    /**
     * Creates a new instance of {@code MiscellaneousBuilder}.
     *
     * @return a new {@code MiscellaneousBuilder} instance
     */
    public static MiscellaneousBuilder builder() {
        return new MiscellaneousBuilder();
    }

    /**
     * Sets the napkin color.
     *
     * @param color the napkin color
     * @return the builder instance
     */
    public MiscellaneousBuilder withNapkinsColor(NapkinsColors color) {
        this.napkinsColors = color;
        return this;
    }

    /**
     * Sets whether flower decoration is included.
     *
     * @param flowerDecoration true if flower decoration is included
     * @return the builder instance
     */
    public MiscellaneousBuilder withFlowerDecoration(boolean flowerDecoration) {
        this.flowerDecoration = flowerDecoration;
        return this;
    }

    /**
     * Sets whether a candy bar is included.
     *
     * @param candyBar true if a candy bar is included
     * @return the builder instance
     */
    public MiscellaneousBuilder withCandyBar(boolean candyBar) {
        this.candyBar = candyBar;
        return this;
    }

    /**
     * Sets whether a photo corner is included.
     *
     * @param photoCorner true if a photo corner is included
     * @return the builder instance
     */
    public MiscellaneousBuilder withPhotoCorner(boolean photoCorner) {
        this.photoCorner = photoCorner;
        return this;
    }

    /**
     * Sets the music provider.
     *
     * @param musicProvider the name of the music provider
     * @return the builder instance
     */
    public MiscellaneousBuilder withMusicProvider(String musicProvider) {
        this.musicProvider = musicProvider;
        return this;
    }

    /**
     * Sets the cake provider.
     *
     * @param cakeProvider the name of the cake provider
     * @return the builder instance
     */
    public MiscellaneousBuilder withCakeProvider(String cakeProvider) {
        this.cakeProvider = cakeProvider;
        return this;
    }

    /**
     * Sets the candy provider.
     *
     * @param candyProvider the name of the candy provider
     * @return the builder instance
     */
    public MiscellaneousBuilder withCandyProvider(String candyProvider) {
        this.candyProvider = candyProvider;
        return this;
    }

    /**
     * Builds and returns a {@link Miscellaneous} object using the provided configuration.
     *
     * @return a new {@link Miscellaneous} instance
     */
    public Miscellaneous build() {
        Miscellaneous misc = new Miscellaneous();
        misc.setNapkinsColors(napkinsColors);
        misc.setFlowerDecoration(flowerDecoration);
        misc.setCandyBar(candyBar);
        misc.setPhotoCorner(photoCorner);
        misc.setMusicProvider(musicProvider);
        misc.setCakeProvider(cakeProvider);
        misc.setCandyProvider(candyProvider);
        return misc;
    }
}
