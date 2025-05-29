package com.eventsapp.backend.repository;

import com.eventsapp.backend.model.Event;
import com.eventsapp.backend.model.Client;
import com.eventsapp.backend.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for {@link Event} entities.
 * Provides CRUD operations and custom query methods related to events.
 */
public interface EventRepository extends JpaRepository<Event, Long> {

    /**
     * Finds all events associated with a given client.
     *
     * @param client the client entity to filter events by
     * @return a list of events containing the given client
     */
    List<Event> findByClientIdsContaining(Client client);

    /**
     * Finds all events associated with a given client.
     * Alias to findByClientIdsContaining.
     *
     * @param client the client entity to filter events by
     * @return a list of events containing the given client
     */
    List<Event> findByClientIdsContains(Client client);

    /**
     * Finds all events taking place at a given venue.
     *
     * @param venue the venue entity to filter events by
     * @return a list of events at the specified venue
     */
    List<Event> findByVenue(Venue venue);

    /**
     * Finds all events taking place at a venue with the given venue ID.
     *
     * @param venueId the ID of the venue to filter events by
     * @return a list of events at the specified venue
     */
    List<Event> findByVenueId(int venueId);
}
