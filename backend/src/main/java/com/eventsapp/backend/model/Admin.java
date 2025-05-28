package com.eventsapp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Table(name="admins")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User
{
    @ManyToMany
    @JoinTable(
            name="admin_venue",
            joinColumns=@JoinColumn(name="admins"),
            inverseJoinColumns = @JoinColumn(name="venues")
    )
    private List<Venue> venues;
}
