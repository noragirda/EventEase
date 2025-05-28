package com.eventsapp.backend.model;

import com.eventsapp.backend.model.enums.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="events")
@NoArgsConstructor
@AllArgsConstructor
public class Event
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EventType eventType;
    @ManyToMany
    @JoinTable(
            name="event_client",
            joinColumns=@JoinColumn(name="clients"),
            inverseJoinColumns = @JoinColumn(name="events")
    )
    private List<Client> clientIds;
    @Column(nullable = false)
    private Date eventDate;
    @Column(nullable = false)
    private int finalAdultCount;
    @Column
    private int calculatedPricePerAdult;
    @Column
    private int calculatedPricePerChild;
    @Column
    private int vegetarians;
    @Column
    private int vegans;

    @ManyToOne
    private Menu menu;

    @ManyToOne
    private Venue venue;

    @ManyToMany
    @JoinTable(
            name = "events_drinks",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "drink_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"event_id", "drink_id"})
    )
    private List<Drink> drinks;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "miscellaneous_id")
    private Miscellaneous miscellaneous;


    @ManyToMany
    @JoinTable(
            name = "events_fruits",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "fruit_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"event_id", "fruit_id"})
    )
    private List<Fruits> fruits;
    @Column(nullable = false)
    private LocalDateTime startingTime;









}
