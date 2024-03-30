package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.Post;
import com.bezkoder.springjwt.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {

    private final PostRepository repository;

    @Autowired
    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Post savePost(Post post) {
        return repository.save(post);
    }

    public List<Post> getAllPost() {
        return repository.findAll();
    }

    public Post getPostById(Long id) throws Exception {
        Optional<Post> optionalPost = repository.findById(id);
        return optionalPost.orElseThrow(() -> new Exception("Post not found with ID: " + id));
    }

    public void deletePostById(Long id) throws Exception {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new Exception("Post not found with ID: " + id);
        }
    }

    public Post updatePost(Post post) throws Exception {
        if (repository.existsById(post.getId())) {
            return repository.save(post);
        } else {
            throw new Exception("Post not found with ID: " + post.getId());
        }
    }

    public List<String> uploadImages(List<MultipartFile> images) throws IOException {
        // Implement image uploading logic here
        // This example saves images to a directory named "uploads" in the current working directory
        // You can replace this with your preferred image storage solution
        String uploadDirectory = "uploads";
        File directory = new File(uploadDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }

        // List to store URLs of uploaded images
        List<String> imageUrls = new ArrayList<>();

        for (MultipartFile image : images) {
            String fileName = generateUniqueFileName(image.getOriginalFilename());
            File file = new File(directory.getAbsolutePath() + File.separator + fileName);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(image.getBytes());
                String imageUrl = "/uploads/" + fileName;
                imageUrls.add(imageUrl);
            }
        }
        return imageUrls;
    }

    private String generateUniqueFileName(String originalFileName) {
        String extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
        return UUID.randomUUID().toString() + extension;
    }
}
