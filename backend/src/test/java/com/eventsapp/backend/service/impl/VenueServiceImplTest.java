package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.dto.VenueRequest;
import com.eventsapp.backend.dto.VenueResponse;
import com.eventsapp.backend.dto.VenueResponseBooking;
import com.eventsapp.backend.exception.NotFoundException;
import com.eventsapp.backend.mapper.VenueMapper;
import com.eventsapp.backend.model.Admin;
import com.eventsapp.backend.model.Booking;
import com.eventsapp.backend.model.Venue;
import com.eventsapp.backend.model.enums.Role;
import com.eventsapp.backend.repository.BookingRepository;
import com.eventsapp.backend.repository.UserRepository;
import com.eventsapp.backend.repository.VenueRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.mock.web.MockMultipartFile;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VenueServiceImplTest {

    @Mock
    private VenueRepository venueRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private VenueServiceImpl venueService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllVenues() {
        Venue venue = new Venue();
        venue.setId(1);
        venue.setName("Test Venue");

        when(venueRepository.findAll()).thenReturn(List.of(venue));

        List<VenueResponse> responses = venueService.getAllVenues();

        assertEquals(1, responses.size());
        assertEquals("Test Venue", responses.get(0).getName());
    }

    @Test
    void testCreateVenue() {
        VenueRequest request = new VenueRequest("Test", "Description", 100, "Providing");
        MockMultipartFile file = new MockMultipartFile("image", "image.jpg", "image/jpeg", "dummy".getBytes());

        Venue venue = new Venue();
        venue.setId(1);
        venue.setName("Test");

        when(venueRepository.save(any(Venue.class))).thenReturn(venue);

        VenueResponse response = venueService.createVenue(request, file);

        assertNotNull(response);
        assertEquals("Test", response.getName());
    }

    @Test
    void testUpdateVenue() {
        Venue existingVenue = new Venue();
        existingVenue.setId(1);
        existingVenue.setName("Old");

        VenueRequest request = new VenueRequest("Updated", "Desc", 120, "New Services");
        MockMultipartFile file = new MockMultipartFile("image", "image.jpg", "image/jpeg", "dummy".getBytes());

        when(venueRepository.findById(1)).thenReturn(Optional.of(existingVenue));
        when(venueRepository.save(any(Venue.class))).thenAnswer(i -> i.getArgument(0));

        VenueResponse response = venueService.updateVenue(1, request, file);

        assertEquals("Updated", response.getName());
    }

    @Test
    void testUpdateVenue_NotFound() {
        VenueRequest request = new VenueRequest("Name", "Desc", 100, "Providing");
        when(venueRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> venueService.updateVenue(1, request, null));
    }

    @Test
    void testAssignAdminsToVenue() {
        Venue venue = new Venue();
        venue.setId(1);

        Admin admin = new Admin();
        admin.setId(100L);
        admin.setVenues(new ArrayList<>());

        when(venueRepository.findById(1)).thenReturn(Optional.of(venue));
        when(userRepository.findAllById(List.of(100L))).thenReturn(List.of(admin));

        venueService.assignAdminsToVenue(1, List.of(100L));

        assertTrue(admin.getVenues().contains(venue));
        verify(userRepository).saveAll(List.of(admin));
    }

    @Test
    void testGetVenuesWithBookedDates() {
        Venue venue = new Venue();
        venue.setId(1);
        venue.setName("Hall A");
        venue.setGuestCapacity(200);
        venue.setDescription("Main Hall");

        Booking booking = new Booking();
        booking.setEventDate(Date.from(LocalDate.of(2025, 6, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        booking.setVenueId(venue);

        when(venueRepository.findAll()).thenReturn(List.of(venue));
        when(bookingRepository.findByVenueId(venue)).thenReturn(List.of(booking));

        List<VenueResponseBooking> result = venueService.getVenuesWithBookedDates();

        assertEquals(1, result.size());
        assertEquals("Hall A", result.get(0).getName());
        assertTrue(result.get(0).getBookedDates().contains(LocalDate.of(2025, 6, 1)));
    }

    @Test
    void testGetVenuesForAdmin() {
        Venue v1 = new Venue();
        v1.setId(1);
        v1.setName("Hall 1");

        Admin admin = new Admin();
        admin.setEmail("admin@example.com");
        admin.setVenues(List.of(v1));

        when(userRepository.findByEmail("admin@example.com")).thenReturn(Optional.of(admin));

        List<VenueResponse> result = venueService.getVenuesForAdmin("admin@example.com");

        assertEquals(1, result.size());
        assertEquals("Hall 1", result.get(0).getName());
    }
}
