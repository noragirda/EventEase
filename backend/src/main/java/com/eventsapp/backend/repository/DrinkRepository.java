package com.eventsapp.backend.repository;

import com.eventsapp.backend.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Drink} entities.
 * Provides CRUD operations and query methods for drinks.
 */
@Repository
public interface DrinkRepository extends JpaRepository<Drink, Integer> {
}
