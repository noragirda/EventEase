package com.eventsapp.backend.mapper;

import com.eventsapp.backend.dto.*;
import com.eventsapp.backend.model.*;

public class MenuMapper {

    // --------- APETIZER ----------
    public ApetizerDTO toApetizerDTO(Apetizer apetizer) {
        return new ApetizerDTO(
                apetizer.getId(),
                apetizer.getName(),
                apetizer.getMaxNumberOfPieces()
        );
    }

    public Apetizer toApetizerEntity(ApetizerDTO dto) {
        Apetizer apetizer = new Apetizer();
        apetizer.setId(dto.getId());
        apetizer.setName(dto.getName());
        apetizer.setMaxNumberOfPieces(dto.getMaxNumberOfPieces());
        return apetizer;
    }

    // --------- SOUP ----------
    public SoupDTO toSoupDTO(Soup soup) {
        return new SoupDTO(
                soup.getId(),
                soup.getName()
        );
    }

    public Soup toSoupEntity(SoupDTO dto) {
        Soup soup = new Soup();
        soup.setId(dto.getId());
        soup.setName(dto.getName());
        return soup;
    }

    // --------- DRINK ----------
    public DrinkDTO toDrinkDTO(Drink drink) {
        return new DrinkDTO(
                drink.getId(),
                drink.getName(),
                drink.getDrinkType()
        );
    }

    public Drink toDrinkEntity(DrinkDTO dto) {
        Drink drink = new Drink();
        drink.setId(dto.getId());
        drink.setName(dto.getName());
        drink.setDrinkType(dto.getDrinkType());
        return drink;
    }

    // --------- MAIN COURSE ----------
    public MainCourseDTO toMainCourseDTO(MainCourse course) {
        return new MainCourseDTO(
                course.getId(),
                course.getName(),
                course.getDescription(),
                course.getMainElement1(),
                course.getMainElement2(),
                course.getCookedVeggies(),
                course.getStarches(),
                course.getSalads(),
                course.getSauce()
        );
    }

    public MainCourse toMainCourseEntity(MainCourseDTO dto) {
        MainCourse course = new MainCourse();
        course.setId(dto.getId());
        course.setName(dto.getName());
        course.setDescription(dto.getDescription());
        course.setMainElement1(dto.getMainElement1());
        course.setMainElement2(dto.getMainElement2());
        course.setCookedVeggies(dto.getCookedVeggies());
        course.setStarches(dto.getStarches());
        course.setSalads(dto.getSalads());
        course.setSauce(dto.getSauce());
        return course;
    }
}
