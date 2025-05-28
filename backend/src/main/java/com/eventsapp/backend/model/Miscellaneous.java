package com.eventsapp.backend.model;

import com.eventsapp.backend.model.enums.NapkinsColors;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Miscellaneous_Tab")
public class Miscellaneous
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private NapkinsColors napkinsColors;

    @Column(nullable = false)
    private boolean flowerDecoration;

    @Column(nullable = false)
    private boolean candyBar;

    @Column(nullable = false)
    private boolean photoCorner;

    @Column(nullable = false)
    private String musicProvider;

    @Column(nullable = false)
    private String cakeProvider;

    @Column(nullable = false)
    private String candyProvider;





}
