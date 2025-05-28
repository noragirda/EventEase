package com.eventsapp.backend.repository;

import com.eventsapp.backend.model.Apetizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApetizerRepository extends JpaRepository<Apetizer, Integer>
{

}