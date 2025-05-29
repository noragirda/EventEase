package com.eventsapp.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring MVC configuration class that exposes uploaded files through a static resource handler.
 * This allows serving files (e.g., venue images) from the local file system via HTTP.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Maps the URL path `/uploads/**` to the local `uploads/` folder on the file system.
     * Enables access to uploaded images or files via HTTP requests.
     *
     * Example:
     * <pre>
     *     /uploads/venue1.jpg → file:uploads/venue1.jpg
     * </pre>
     *
     * @param registry the resource handler registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/");
    }
}
