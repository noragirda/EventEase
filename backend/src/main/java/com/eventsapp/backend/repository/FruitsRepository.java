package com.eventsapp.backend.repository;

import com.eventsapp.backend.model.Fruits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitsRepository extends JpaRepository<Fruits, Integer> {
}
