package com.eventsapp.backend.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Service for handling image file storage.
 * Provides functionality to save uploaded image files to the filesystem.
 */
@Service
public class ImageService {

    private final String uploadDir = "uploads/";

    /**
     * Saves the provided multipart image file to the upload directory with a unique filename.
     *
     * @param file the multipart image file to save
     * @return the unique filename under which the image was saved, or null if file is empty or null
     * @throws RuntimeException if an I/O error occurs while saving the file
     */
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
