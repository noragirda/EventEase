package com.eventsapp.backend.mapper;

import com.eventsapp.backend.dto.*;
import com.eventsapp.backend.model.*;

/**
 * Mapper class responsible for converting between Menu-related entity objects and their corresponding DTOs.
 */
public class MenuMapper {

    // --------- APETIZER ----------

    /**
     * Converts an Apetizer entity to an ApetizerDTO.
     *
     * @param apetizer the Apetizer entity to convert
     * @return the corresponding ApetizerDTO
     */
    public ApetizerDTO toApetizerDTO(Apetizer apetizer) {
        return new ApetizerDTO(
                apetizer.getId(),
                apetizer.getName(),
                apetizer.getMaxNumberOfPieces()
        );
    }

    /**
     * Converts an ApetizerDTO to an Apetizer entity.
     *
     * @param dto the ApetizerDTO to convert
     * @return the corresponding Apetizer entity
     */
    public Apetizer toApetizerEntity(ApetizerDTO dto) {
        Apetizer apetizer = new Apetizer();
        apetizer.setId(dto.getId());
        apetizer.setName(dto.getName());
        apetizer.setMaxNumberOfPieces(dto.getMaxNumberOfPieces());
        return apetizer;
    }

    // --------- SOUP ----------

    /**
     * Converts a Soup entity to a SoupDTO.
     *
     * @param soup the Soup entity to convert
     * @return the corresponding SoupDTO
     */
    public SoupDTO toSoupDTO(Soup soup) {
        return new SoupDTO(
                soup.getId(),
                soup.getName()
        );
    }

    /**
     * Converts a SoupDTO to a Soup entity.
     *
     * @param dto the SoupDTO to convert
     * @return the corresponding Soup entity
     */
    public Soup toSoupEntity(SoupDTO dto) {
        Soup soup = new Soup();
        soup.setId(dto.getId());
        soup.setName(dto.getName());
        return soup;
    }

    // --------- DRINK ----------

    /**
     * Converts a Drink entity to a DrinkDTO.
     *
     * @param drink the Drink entity to convert
     * @return the corresponding DrinkDTO
     */
    public DrinkDTO toDrinkDTO(Drink drink) {
        return new DrinkDTO(
                drink.getId(),
                drink.getName(),
                drink.getDrinkType()
        );
    }

    /**
     * Converts a DrinkDTO to a Drink entity.
     *
     * @param dto the DrinkDTO to convert
     * @return the corresponding Drink entity
     */
    public Drink toDrinkEntity(DrinkDTO dto) {
        Drink drink = new Drink();
        drink.setId(dto.getId());
        drink.setName(dto.getName());
        drink.setDrinkType(dto.getDrinkType());
        return drink;
    }

    // --------- MAIN COURSE ----------

    /**
     * Converts a MainCourse entity to a MainCourseDTO.
     *
     * @param course the MainCourse entity to convert
     * @return the corresponding MainCourseDTO
     */
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

    /**
     * Converts a MainCourseDTO to a MainCourse entity.
     *
     * @param dto the MainCourseDTO to convert
     * @return the corresponding MainCourse entity
     */
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
