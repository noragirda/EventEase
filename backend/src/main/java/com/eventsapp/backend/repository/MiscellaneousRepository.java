package com.eventsapp.backend.repository;

import com.eventsapp.backend.model.Miscellaneous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiscellaneousRepository extends JpaRepository<Miscellaneous, Integer> {
}
