package com.eventsapp.backend.repository;

import com.eventsapp.backend.model.Soup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoupRepository extends JpaRepository<Soup, Integer> {}