package com.eventsapp.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Service responsible for sending emails.
 * Uses {@link JavaMailSender} to send email notifications.
 */
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    /**
     * Sends a booking approval email to the client notifying that their event booking has been confirmed.
     *
     * @param to         the recipient email address
     * @param clientName the name of the client
     * @param venueName  the name of the venue booked
     * @param date       the date of the event
     */
    public void sendBookingApprovedEmail(String to, String clientName, String venueName, String date) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Your Event Booking is Confirmed 🎉");
        message.setText("Dear " + clientName + ",\n\n" +
                "Great news! Your event booking for the venue '" + venueName + "' on " + date +
                " has been approved. You can now start organizing your event through your dashboard.\n\n" +
                "Best wishes,\nEventEase Team");

        mailSender.send(message);
    }
}
