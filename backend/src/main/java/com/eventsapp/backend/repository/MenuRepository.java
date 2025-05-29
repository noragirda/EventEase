package com.eventsapp.backend.repository;

import com.eventsapp.backend.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Menu} entities.
 * Provides CRUD operations and query methods for menus.
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
