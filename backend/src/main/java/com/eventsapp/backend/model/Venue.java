package com.eventsapp.backend.model;

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
@Table(name="venues")
public class Venue
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String name;
    @Column
    private String description;

    @Column(nullable = false)
    private int guestCapacity;

    @Column(nullable = false)
    private String providing;

    @Column(name = "image_url")
    private String imageUrl; // e.g., "venue1.jpg"


}
