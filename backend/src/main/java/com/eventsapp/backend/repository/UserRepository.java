package com.eventsapp.backend.repository;

import com.eventsapp.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for {@link User} entities.
 * Provides CRUD operations and query methods for users.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by their unique email address.
     *
     * @param email the email to search by
     * @return an {@link Optional} containing the found user or empty if not found
     */
    Optional<User> findByEmail(String email);
}
