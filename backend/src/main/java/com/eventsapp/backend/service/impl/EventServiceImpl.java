package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.dto.*;
import com.eventsapp.backend.model.*;
import com.eventsapp.backend.model.enums.NapkinsColors;
import com.eventsapp.backend.repository.*;
import com.eventsapp.backend.service.impl.EventService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final MenuRepository menuRepository;
    private final DrinkRepository drinkRepository;
    private final FruitsRepository fruitsRepository;
    private final MiscellaneousRepository miscellaneousRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final ApetizerRepository apetizerRepository;
    private final SoupRepository soupRepository;
    private final MainCourseRepository mainCourseRepository;

    @Override
    public void updateClientEvent(Long id, String clientEmail, EventUpdateRequest request) {
        User user = userRepository.findByEmail(clientEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!(user instanceof Client client)) throw new RuntimeException("Not a client");

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        if (!event.getClientIds().contains(client)) throw new RuntimeException("Unauthorized");

        long daysUntilEvent = ChronoUnit.DAYS.between(LocalDate.now(), event.getEventDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        if (daysUntilEvent <= 10) throw new RuntimeException("Event too close to update.");

        // Update basic fields
        event.setEventType(request.getEventType());
        event.setFinalAdultCount(request.getFinalAdultCount());
        event.setVegetarians(request.getVegetarians());
        event.setVegans(request.getVegans());
        event.setStartingTime(request.getStartingTime());

        // Update menu
        if (request.getMenuId() != null) {
            Menu menu = menuRepository.findById(request.getMenuId())
                    .orElseThrow(() -> new RuntimeException("Menu not found"));
            event.setMenu(menu);
        }
        if (request.getStartingTime() != null) {
            event.setStartingTime(request.getStartingTime());
        }



        // Update drinks
        event.getDrinks().clear();
        if (request.getDrinkIds() != null) {
            List<Drink> drinks = drinkRepository.findAllById(request.getDrinkIds());
            event.setDrinks(drinks);
        }

        // Update fruits
        event.getFruits().clear();
        if (request.getFruitIds() != null) {
            List<Fruits> fruits = fruitsRepository.findAllById(request.getFruitIds());
            event.setFruits(fruits);
        }

        // Update misc
        if (request.getMiscellaneousId() != null) {
            Miscellaneous misc = miscellaneousRepository.findById(request.getMiscellaneousId())
                    .orElseThrow(() -> new RuntimeException("Misc option not found"));
            event.setMiscellaneous(misc);
        }

        eventRepository.save(event);
    }
    @Override
    @Transactional
    public void assignCustomMenu(Long eventId, CreateMenuRequest request) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        List<Apetizer> apetizers = apetizerRepository.findAllById(request.getApetizerIds());
        List<Soup> soups = soupRepository.findAllById(request.getSoupIds());
        MainCourse mainCourse = mainCourseRepository.findById(request.getMainCourseId())
                .orElseThrow(() -> new RuntimeException("MainCourse not found"));

        Menu menu = new Menu();
        menu.setApetizers(apetizers);
        menu.setSoups(soups);
        menu.setMainCourse(mainCourse);

        menu = menuRepository.save(menu);  // ✅ this creates the new Menu in DB

        event.setMenu(menu);               // ✅ this links it to the Event
        eventRepository.save(event);      // ✅ save the event with the new menu
    }


    @Override
    public void assignCustomMisc(Long eventId, CreateMiscRequest request) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        Miscellaneous misc = new Miscellaneous();
        misc.setNapkinsColors(NapkinsColors.valueOf(request.getNapkinsColors()));
        misc.setFlowerDecoration(request.isFlowerDecoration());
        misc.setCandyBar(request.isCandyBar());
        misc.setPhotoCorner(request.isPhotoCorner());
        misc.setMusicProvider(request.getMusicProvider());
        misc.setCakeProvider(request.getCakeProvider());
        misc.setCandyProvider(request.getCandyProvider());

        miscellaneousRepository.save(misc);
        event.setMiscellaneous(misc);
        eventRepository.save(event);
    }
    @Override
    @Transactional
    public void assignMiscellaneousToEvent(Long eventId, MiscellaneousRequest request) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        Miscellaneous misc = new Miscellaneous();
        misc.setNapkinsColors(request.getNapkinsColors());
        misc.setFlowerDecoration(request.isFlowerDecoration());
        misc.setCandyBar(request.isCandyBar());
        misc.setPhotoCorner(request.isPhotoCorner());
        misc.setMusicProvider(request.getMusicProvider());
        misc.setCakeProvider(request.getCakeProvider());
        misc.setCandyProvider(request.getCandyProvider());

        miscellaneousRepository.save(misc);
        event.setMiscellaneous(misc);
        eventRepository.save(event);
    }
    @Override
    @Transactional
    public void updateMiscellaneous(Long eventId, MiscellaneousRequest request) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        Miscellaneous misc = event.getMiscellaneous();

        if (misc == null) {
            misc = new Miscellaneous();
        }

        misc.setNapkinsColors(request.getNapkinsColors());
        misc.setFlowerDecoration(request.isFlowerDecoration());
        misc.setCandyBar(request.isCandyBar());
        misc.setPhotoCorner(request.isPhotoCorner());
        misc.setMusicProvider(request.getMusicProvider());
        misc.setCakeProvider(request.getCakeProvider());
        misc.setCandyProvider(request.getCandyProvider());

        miscellaneousRepository.save(misc);
        event.setMiscellaneous(misc);
        eventRepository.save(event);
    }
    @Override
    public List<VenueWithEventsResponse> getVenuesWithEventsByAdminEmail(String email) {
        Admin admin = (Admin) userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        return admin.getVenues().stream().map(venue -> {
            VenueWithEventsResponse dto = new VenueWithEventsResponse();
            dto.setVenueId(venue.getId());
            dto.setName(venue.getName());
            dto.setImageUrl(venue.getImageUrl());

            List<EventResponse> events = eventRepository.findByVenue(venue).stream().map(event -> {
                EventResponse e = new EventResponse();
                e.setId(event.getId());
                e.setStartingTime(event.getStartingTime());
                e.setFinalAdultCount(event.getFinalAdultCount());
                e.setCalculatedPricePerAdult(event.getCalculatedPricePerAdult());
                e.setCalculatedPricePerChild(event.getCalculatedPricePerChild());
                return e;
            }).toList();

            dto.setEvents(events);
            return dto;
        }).toList();
    }
    @Override
    public void updateEventPrices(Long eventId, AdminEventPriceUpdateRequest request) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.setCalculatedPricePerAdult(request.getCalculatedPricePerAdult());
        event.setCalculatedPricePerChild(request.getCalculatedPricePerChild());

        eventRepository.save(event);
    }
    @Override
    public FullEventDetailsResponse getFullEventDetails(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        FullEventDetailsResponse dto = new FullEventDetailsResponse();
        dto.setEventId(event.getId());
        dto.setEventType(event.getEventType());
        dto.setEventDate(event.getEventDate());
        dto.setStartingTime(event.getStartingTime());
        dto.setFinalAdultCount(event.getFinalAdultCount());
        dto.setCalculatedPricePerAdult(event.getCalculatedPricePerAdult());
        dto.setCalculatedPricePerChild(event.getCalculatedPricePerChild());
        dto.setVegetarians(event.getVegetarians());
        dto.setVegans(event.getVegans());

        // Menu
        if (event.getMenu() != null) {
            dto.setApetizers(event.getMenu().getApetizers().stream().map(a -> a.getName()).toList());
            dto.setSoups(event.getMenu().getSoups().stream().map(s -> s.getName()).toList());
            dto.setMainCourse(event.getMenu().getMainCourse() != null ? event.getMenu().getMainCourse().getName() : null);
        }

        // Miscellaneous
        if (event.getMiscellaneous() != null) {
            dto.setNapkinsColor(event.getMiscellaneous().getNapkinsColors());
            dto.setFlowerDecoration(event.getMiscellaneous().isFlowerDecoration());
            dto.setCandyBar(event.getMiscellaneous().isCandyBar());
            dto.setPhotoCorner(event.getMiscellaneous().isPhotoCorner());
            dto.setMusicProvider(event.getMiscellaneous().getMusicProvider());
            dto.setCakeProvider(event.getMiscellaneous().getCakeProvider());
            dto.setCandyProvider(event.getMiscellaneous().getCandyProvider());
        }

        dto.setDrinks(event.getDrinks().stream().map(Drink::getName).toList());
        dto.setFruits(event.getFruits().stream().map(Fruits::getName).toList());

        return dto;
    }






}
