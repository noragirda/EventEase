package com.eventsapp.backend.repository;

import com.eventsapp.backend.model.Event;
import com.eventsapp.backend.model.Client;
import com.eventsapp.backend.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByClientIdsContaining(Client client);
    List<Event> findByClientIdsContains(Client client);
    List<Event> findByVenue(Venue venue);
    List<Event> findByVenueId(int venueId);

}
