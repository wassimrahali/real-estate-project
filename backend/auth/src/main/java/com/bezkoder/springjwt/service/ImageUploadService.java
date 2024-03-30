package com.bezkoder.springjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service

public class ImageUploadService {

    @Value("${upload.path}")
    private String uploadPath; // Path where images will be stored

    public List<String> uploadImages(List<MultipartFile> images) throws IOException {
        List<String> imageUrls = new ArrayList<>();

        for (MultipartFile image : images) {
            String fileName = StringUtils.cleanPath(image.getOriginalFilename());
            String fileExtension = fileName.substring(fileName.lastIndexOf("."));
            String generatedFileName = UUID.randomUUID().toString() + fileExtension;

            // Save the file to the upload directory
            String filePath = uploadPath + File.separator + generatedFileName;
            File convertFile = new File(filePath);
            convertFile.createNewFile();
            try (FileOutputStream fout = new FileOutputStream(convertFile)) {
                fout.write(image.getBytes());
            } catch (IOException e) {
                throw new IOException("Could not save image: " + fileName, e);
            }

            // Add the URL of the uploaded image to the list
            String imageUrl = "/uploads/" + generatedFileName;
            imageUrls.add(imageUrl);
        }

        return imageUrls;
    }
}
