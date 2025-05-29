package com.eventsapp.backend.model;

import com.eventsapp.backend.model.enums.NapkinsColors;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity representing miscellaneous event customization options.
 * Includes decoration choices, music, cake, and candy providers.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Miscellaneous_Tab")
public class Miscellaneous {

    /**
     * Unique identifier for the miscellaneous options.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Color of the napkins chosen for the event.
     */
    @Enumerated(EnumType.STRING)
    private NapkinsColors napkinsColors;

    /**
     * Whether flower decoration is included.
     */
    @Column(nullable = false)
    private boolean flowerDecoration;

    /**
     * Whether a candy bar is included.
     */
    @Column(nullable = false)
    private boolean candyBar;

    /**
     * Whether a photo corner is included.
     */
    @Column(nullable = false)
    private boolean photoCorner;

    /**
     * Name of the music provider for the event.
     */
    @Column(nullable = false)
    private String musicProvider;

    /**
     * Name of the cake provider for the event.
     */
    @Column(nullable = false)
    private String cakeProvider;

    /**
     * Name of the candy provider for the event.
     */
    @Column(nullable = false)
    private String candyProvider;
}
