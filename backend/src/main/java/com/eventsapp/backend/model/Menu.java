package com.eventsapp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Entity representing a menu composed of appetizers, soups, and a main course.
 * A menu is assigned to events and contains the food items selected.
 */
@Getter
@Setter
@Entity
@Table(name = "menus")
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    /**
     * Unique identifier for the menu.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * List of appetizers included in the menu.
     */
    @ManyToMany
    @JoinTable(
            name = "menus_apetizers",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "apetizers_id")
    )
    private List<Apetizer> apetizers;

    /**
     * List of soups included in the menu.
     */
    @ManyToMany
    @JoinTable(
            name = "menus_soups",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "soup_id")
    )
    private List<Soup> soups;

    /**
     * The main course associated with the menu.
     */
    @ManyToOne
    @JoinColumn(name = "main_course_id")
    private MainCourse mainCourse;
}
