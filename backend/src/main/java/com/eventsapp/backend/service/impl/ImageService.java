package com.eventsapp.backend.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageService {

    private final String uploadDir = "uploads/";

    public String saveImage(MultipartFile file) {
        if (file == null || file.isEmpty()) return null;

        String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
        Path path = Paths.get(uploadDir + fileName);

        try {
            Files.createDirectories(path.getParent());
            Files.write(path, file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to store image", e);
        }

        return fileName;
    }
}
