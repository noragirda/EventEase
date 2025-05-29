package com.eventsapp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Entity representing a client user in the system.
 * Extends the abstract {@link User} class and defines a relationship to the events they are associated with.
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
@DiscriminatorValue("CLIENT")
public class Client extends User {

    /**
     * List of events that the client is associated with.
     * A client can participate in multiple events, and an event can have multiple clients.
     */
    @ManyToMany
    @JoinTable(
            name = "client_event",
            joinColumns = @JoinColumn(name = "clients"),
            inverseJoinColumns = @JoinColumn(name = "events")
    )
    private List<Event> events;
}
