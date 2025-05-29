package com.eventsapp.backend.repository;

import com.eventsapp.backend.model.Soup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Soup} entities.
 * Provides CRUD operations and query methods for soups.
 */
@Repository
public interface SoupRepository extends JpaRepository<Soup, Integer> {
}
