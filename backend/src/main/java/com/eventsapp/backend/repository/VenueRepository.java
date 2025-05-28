package com.eventsapp.backend.repository;

import com.eventsapp.backend.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Integer> {
    boolean existsByName(String name);
}
