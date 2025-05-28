package com.eventsapp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="clients")
@DiscriminatorValue("CLIENT")
public class Client extends User
{
    @ManyToMany
    @JoinTable(
            name="client_event",
            joinColumns=@JoinColumn(name="clients"),
            inverseJoinColumns = @JoinColumn(name="events")
    )
    private List<Event> events;
}
