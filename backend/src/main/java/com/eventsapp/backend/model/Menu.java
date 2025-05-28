package com.eventsapp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="menus")
@NoArgsConstructor
@AllArgsConstructor
public class Menu
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(
            name = "menus_apetizers",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "apetizers_id")
    )
    private List<Apetizer> apetizers;

    @ManyToMany
    @JoinTable(
            name = "menus_soups",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "soup_id")
    )
    private List<Soup> soups;


    @ManyToOne
    @JoinColumn(name = "main_course_id")
    private MainCourse mainCourse;

}
