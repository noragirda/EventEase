package com.eventsapp.backend.model;

import com.eventsapp.backend.model.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Abstract base class representing a user in the system.
 * <p>
 * Implements Spring Security's {@link UserDetails} interface for authentication and authorization.
 * Uses JOINED inheritance strategy to support different user types (e.g., Admin, Client).
 */
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorColumn
public abstract class User implements UserDetails {

    /**
     * Unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Full name of the user.
     */
    private String name;

    /**
     * Unique email address of the user, used as username for authentication.
     */
    @Column(unique = true, nullable = false)
    private String email;

    /**
     * Password hash for user authentication.
     */
    @Column(nullable = false)
    private String password;

    /**
     * Role of the user (e.g., ADMIN, CLIENT).
     */
    @Enumerated(EnumType.STRING)
    private Role role;

    /**
     * Returns the authorities granted to the user.
     * In this case, a simple authority based on the user's role.
     *
     * @return a collection of granted authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    /**
     * Returns the username used to authenticate the user.
     * In this implementation, the email is the username.
     *
     * @return the username (email)
     */
    @Override
    public String getUsername() {
        return email;
    }

    /**
     * Indicates whether the user's account has expired.
     * Always returns true (account never expires).
     *
     * @return true if the account is non-expired
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked.
     * Always returns true (account never locked).
     *
     * @return true if the account is non-locked
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials have expired.
     * Always returns true (credentials never expire).
     *
     * @return true if credentials are non-expired
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled.
     * Always returns true (account enabled).
     *
     * @return true if the user is enabled
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
