package com.eventsapp.backend.repository;

import com.eventsapp.backend.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Venue} entities.
 * Provides CRUD operations and custom query methods for venues.
 */
@Repository
public interface VenueRepository extends JpaRepository<Venue, Integer> {

    /**
     * Checks if a venue with the specified name exists.
     *
     * @param name the name of the venue to check
     * @return true if a venue with the given name exists, false otherwise
     */
    boolean existsByName(String name);
}
