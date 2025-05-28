package com.eventsapp.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

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