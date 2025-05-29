package com.eventsapp.backend.service.impl;

import com.eventsapp.backend.dto.UserResponse;
import com.eventsapp.backend.dto.VenueRequest;
import com.eventsapp.backend.dto.VenueResponse;
import com.eventsapp.backend.dto.VenueResponseBooking;
import com.eventsapp.backend.exception.NotFoundException;
import com.eventsapp.backend.mapper.UserMapper;
import com.eventsapp.backend.mapper.VenueMapper;
import com.eventsapp.backend.model.Admin;
import com.eventsapp.backend.model.Booking;
import com.eventsapp.backend.model.Venue;
import com.eventsapp.backend.model.enums.Role;
import com.eventsapp.backend.repository.BookingRepository;
import com.eventsapp.backend.repository.UserRepository;
import com.eventsapp.backend.repository.VenueRepository;
import com.eventsapp.backend.service.impl.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service implementation for managing venues, including creation, update, admin assignment,
 * image handling, and retrieval of venues with booking details.
 */
@Service
@RequiredArgsConstructor
public class VenueServiceImpl implements VenueService {

    private final VenueRepository venueRepository;
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final String uploadDir = "uploads/";

    /**
     * Retrieves all venues.
     *
     * @return a list of all venues as VenueResponse DTOs
     */
    @Override
    public List<VenueResponse> getAllVenues() {
        return venueRepository.findAll().stream()
                .map(VenueMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Creates a new venue with optional image upload.
     *
     * @param request the venue creation request data
     * @param image   optional image file for the venue
     * @return the created venue as a VenueResponse DTO
     */
    @Override
    public VenueResponse createVenue(VenueRequest request, MultipartFile image) {
        Venue venue = new Venue();
        fillVenueFields(venue, request, image);
        return VenueMapper.toDto(venueRepository.save(venue));
    }

    /**
     * Updates an existing venue by ID with optional image upload.
     *
     * @param id      the ID of the venue to update
     * @param request the venue update request data
     * @param image   optional image file for the venue
     * @return the updated venue as a VenueResponse DTO
     * @throws NotFoundException if the venue with the specified ID is not found
     */
    @Override
    public VenueResponse updateVenue(int id, VenueRequest request, MultipartFile image) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Venue not found"));

        fillVenueFields(venue, request, image);
        return VenueMapper.toDto(venueRepository.save(venue));
    }

    /**
     * Helper method to fill venue entity fields from request and image.
     *
     * @param venue   the venue entity to update
     * @param request the venue request data
     * @param image   the optional image file
     */
    private void fillVenueFields(Venue venue, VenueRequest request, MultipartFile image) {
        venue.setName(request.getName());
        venue.setDescription(request.getDescription());
        venue.setGuestCapacity(request.getGuestCapacity());
        venue.setProviding(request.getProviding());

        if (image != null && !image.isEmpty()) {
            String fileName = saveImage(image);
            venue.setImageUrl(fileName);
        }
    }

    /**
     * Saves an uploaded image file to the file system.
     *
     * @param file the image file to save
     * @return the saved filename
     * @throws RuntimeException if saving the file fails
     */
    private String saveImage(MultipartFile file) {
        try {
            Files.createDirectories(Paths.get(uploadDir));
            String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + fileName);
            Files.write(filePath, file.getBytes());
            return fileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save image", e);
        }
    }

    /**
     * Retrieves a list of all admins available for a given venue.
     *
     * @param venueId the venue ID
     * @return list of user responses for available admins
     */
    @Override
    public List<UserResponse> getAvailableAdminsForVenue(int venueId) {
        return userRepository.findAll().stream()
                .filter(user -> user.getRole() == Role.ADMIN)
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Assigns a list of admins to a specific venue.
     *
     * @param venueId  the venue ID
     * @param adminIds the list of admin IDs to assign to the venue
     * @throws NotFoundException if the venue is not found
     */
    @Override
    public void assignAdminsToVenue(int venueId, List<Long> adminIds) {
        Venue venue = venueRepository.findById(venueId)
                .orElseThrow(() -> new NotFoundException("Venue not found"));

        List<Admin> admins = userRepository.findAllById(adminIds).stream()
                .filter(user -> user instanceof Admin)
                .map(user -> (Admin) user)
                .collect(Collectors.toList());

        for (Admin admin : admins) {
            if (!admin.getVenues().contains(venue)) {
                admin.getVenues().add(venue);
            }
        }

        userRepository.saveAll(admins);
    }

    /**
     * Retrieves all venues along with their booked dates.
     *
     * @return list of VenueResponseBooking DTOs representing venues with their booked dates
     */
    @Override
    public List<VenueResponseBooking> getVenuesWithBookedDates() {
        List<Venue> venues = venueRepository.findAll();

        return venues.stream().map(venue -> {
            List<LocalDate> bookedDates = bookingRepository.findByVenueId(venue)
                    .stream()
                    .map(Booking::getEventDate)
                    .map(date -> date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                    .collect(Collectors.toList());

            return new VenueResponseBooking(
                    venue.getId(),
                    venue.getName(),
                    venue.getDescription(),
                    venue.getGuestCapacity(),
                    bookedDates
            );
        }).collect(Collectors.toList());
    }

    /**
     * Retrieves all venues managed by a given admin email.
     *
     * @param adminEmail the admin's email address
     * @return list of venues managed by the admin as VenueResponse DTOs
     * @throws RuntimeException if admin is not found
     */
    @Override
    public List<VenueResponse> getVenuesForAdmin(String adminEmail) {
        Admin admin = userRepository.findByEmail(adminEmail)
                .filter(u -> u instanceof Admin)
                .map(u -> (Admin) u)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        return admin.getVenues().stream()
                .map(VenueMapper::toDto)
                .collect(Collectors.toList());
    }
}
