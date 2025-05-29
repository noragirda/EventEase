package com.eventsapp.backend.model.enums;

/**
 * Enum representing the roles a user can have in the system.
 */
public enum Role {

    /** Admin role, with full access to manage users, venues, events, and system settings. */
    ADMIN,

    /** Client role, used for booking venues and managing their own events. */
    CLIENT
}
