package com.eventsapp.backend.factory.impl;

import com.eventsapp.backend.builder.MenuBuilder;
import com.eventsapp.backend.factory.MenuFactory;
import com.eventsapp.backend.model.Apetizer;
import com.eventsapp.backend.model.MainCourse;
import com.eventsapp.backend.model.Menu;
import com.eventsapp.backend.model.Soup;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Default implementation of the {@link MenuFactory} interface.
 * <p>
 * Uses the {@link MenuBuilder} to construct a {@link Menu} object composed of
 * a list of appetizers, soups, and a single main course.
 */
@Component
public class DefaultMenuFactory implements MenuFactory {

    /**
     * Creates a custom {@link Menu} using the provided list of appetizers, soups, and main course.
     * The construction is delegated to the {@link MenuBuilder}.
     *
     * @param apetizers  the list of appetizers to include in the menu
     * @param soups      the list of soups to include in the menu
     * @param mainCourse the main course to include in the menu
     * @return a fully constructed {@link Menu} object
     */
    @Override
    public Menu createCustomMenu(List<Apetizer> apetizers, List<Soup> soups, MainCourse mainCourse) {
        return MenuBuilder.builder()
                .withApetizers(apetizers)
                .withSoups(soups)
                .withMainCourse(mainCourse)
                .build();
    }

}
