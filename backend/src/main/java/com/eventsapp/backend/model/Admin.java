package com.eventsapp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Entity representing an Admin user in the system.
 * Inherits from {@link User} and has access to manage one or more venues.
 */
@Setter
@Getter
@Table(name = "admins")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    /**
     * The list of venues that this admin is responsible for managing.
     *
     * Mapped using a many-to-many relationship with a join table named "admin_venue".
     */
    @ManyToMany
    @JoinTable(
            name = "admin_venue",
            joinColumns = @JoinColumn(name = "admins"),
            inverseJoinColumns = @JoinColumn(name = "venues")
    )
    private List<Venue> venues;
}
