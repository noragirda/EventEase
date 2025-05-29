package com.eventsapp.backend.builder;

import com.eventsapp.backend.model.Apetizer;
import com.eventsapp.backend.model.MainCourse;
import com.eventsapp.backend.model.Menu;
import com.eventsapp.backend.model.Soup;

import java.util.List;

/**
 * Builder class for constructing {@link Menu} instances in a flexible and fluent way.
 * Useful when creating custom menus with varying combinations of appetizers, soups, and main courses.
 */
public class MenuBuilder {

    /**
     * List of appetizers to be included in the menu.
     */
    private List<Apetizer> apetizers;

    /**
     * List of soups to be included in the menu.
     */
    private List<Soup> soups;

    /**
     * The main course for the menu.
     */
    private MainCourse mainCourse;

    /**
     * Initializes a new instance of the {@code MenuBuilder}.
     *
     * @return a new {@code MenuBuilder} instance
     */
    public static MenuBuilder builder() {
        return new MenuBuilder();
    }

    /**
     * Sets the list of appetizers for the menu.
     *
     * @param apetizers the list of appetizers
     * @return the updated builder instance
     */
    public MenuBuilder withApetizers(List<Apetizer> apetizers) {
        this.apetizers = apetizers;
        return this;
    }

    /**
     * Sets the list of soups for the menu.
     *
     * @param soups the list of soups
     * @return the updated builder instance
     */
    public MenuBuilder withSoups(List<Soup> soups) {
        this.soups = soups;
        return this;
    }

    /**
     * Sets the main course for the menu.
     *
     * @param mainCourse the main course
     * @return the updated builder instance
     */
    public MenuBuilder withMainCourse(MainCourse mainCourse) {
        this.mainCourse = mainCourse;
        return this;
    }

    /**
     * Builds the {@link Menu} instance with the configured fields.
     *
     * @return a new {@link Menu} instance
     */
    public Menu build() {
        Menu menu = new Menu();
        menu.setApetizers(apetizers);
        menu.setSoups(soups);
        menu.setMainCourse(mainCourse);
        return menu;
    }
}
