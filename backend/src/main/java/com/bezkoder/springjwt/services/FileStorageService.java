package com.bezkoder.springjwt.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public String saveFile(MultipartFile file) throws IOException {
        String fileName = generateFileName(Objects.requireNonNull(file.getOriginalFilename()));
        Path filePath = Paths.get(uploadDir).resolve(fileName); // Concatenate uploadDir and fileName using resolve

        // Save the file to the upload directory
        Files.copy(file.getInputStream(), filePath);

        // Return the URL of the saved file
        return fileName;
    }

    public String getFilePath(String fileName) {
        return Paths.get(uploadDir).resolve(fileName).toString(); // Return the file path with uploadDir using resolve
    }

    private String generateFileName(String originalFileName) {
        // Generate a unique file name using UUID to avoid naming conflicts
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        return UUID.randomUUID() + extension;
    }
}
