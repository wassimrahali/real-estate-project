// FileStorageService.java
package com.bezkoder.springjwt.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public String saveFile(MultipartFile file) throws IOException {
        String fileName = generateFileName(file.getOriginalFilename());
        Path filePath = Paths.get(uploadDir + fileName);

        // Save the file to the upload directory
        Files.copy(file.getInputStream(), filePath);

        // Return the URL of the saved file
        return "/uploads/" + fileName;
    }

    private String generateFileName(String originalFileName) {
        // Generate a unique file name using UUID to avoid naming conflicts
        return UUID.randomUUID().toString() + "-" + originalFileName;
    }
}
