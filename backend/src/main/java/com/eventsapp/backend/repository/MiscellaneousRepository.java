package com.eventsapp.backend.repository;

import com.eventsapp.backend.model.Miscellaneous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Miscellaneous} entities.
 * Provides CRUD operations and query methods for miscellaneous event options.
 */
@Repository
public interface MiscellaneousRepository extends JpaRepository<Miscellaneous, Integer> {
}
