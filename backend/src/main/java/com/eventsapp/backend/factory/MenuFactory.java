package com.eventsapp.backend.factory;

import com.eventsapp.backend.model.Apetizer;
import com.eventsapp.backend.model.MainCourse;
import com.eventsapp.backend.model.Menu;
import com.eventsapp.backend.model.Soup;

import java.util.List;

/**
 * Factory interface for creating {@link Menu} objects.
 * <p>
 * This interface defines the contract for building a custom menu composed of
 * appetizers, soups, and a main course.
 */
public interface MenuFactory {

    /**
     * Creates a custom {@link Menu} object using the provided list of appetizers,
     * soups, and a single main course.
     *
     * @param apetizers   the list of {@link Apetizer} objects to include in the menu
     * @param soups       the list of {@link Soup} objects to include in the menu
     * @param mainCourse  the {@link MainCourse} object to be included in the menu
     * @return a {@link Menu} object composed of the specified items
     */
    Menu createCustomMenu(List<Apetizer> apetizers, List<Soup> soups, MainCourse mainCourse);
}
