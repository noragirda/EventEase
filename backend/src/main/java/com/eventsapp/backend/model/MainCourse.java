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
@Table(name="main_courses")
@NoArgsConstructor
@AllArgsConstructor
public class MainCourse
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private String mainElement1;
    @Column(nullable = false)
    private String mainElement2;
    @Column
    private String cookedVeggies;
    @Column(nullable = false)
    private String starches;
    @Column
    private String salads;
    @Column(nullable = false)
    private String sauce;


}