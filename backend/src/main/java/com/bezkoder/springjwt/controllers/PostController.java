package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Post;
import com.bezkoder.springjwt.services.FileStorageService;
import com.bezkoder.springjwt.services.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping
    public ResponseEntity<?> savePost(@RequestParam("imageFile") MultipartFile[] files, @RequestParam("post") String postJson) {
        try {
            Post post = new ObjectMapper().readValue(postJson, Post.class);

            // Set the publication time to the current date and time
            post.setTempsPub(LocalDateTime.now());

            post.setImages(saveImages(files)); // Save the post with images
            Post savedPost = postService.savePost(post);
            return ResponseEntity.ok(savedPost); // Return saved post
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save post: " + e.getMessage());
        }
    }

    private List<String> saveImages(MultipartFile[] files) {
        List<String> imageUrls = new ArrayList<>();
        for (MultipartFile file : files) {
            try {
                String imageUrl = fileStorageService.saveFile(file); // Save file to storage
                imageUrls.add(imageUrl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return imageUrls;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id) {
        try {
            Post post = postService.getPostByID(id);
            if (post != null) {
                return ResponseEntity.ok(post);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve post: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPost() {
        try {
            List<Post> posts = postService.getAllPost();
            return ResponseEntity.ok(posts);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Long id) {
        try {
            postService.deletePostByID(id);
            return ResponseEntity.ok("Post deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete post: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updatePost(@RequestBody Post post) {
        try {
            Post updatedPost = postService.updatePost(post);
            if (updatedPost != null) {
                return ResponseEntity.ok(updatedPost);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update post: " + e.getMessage());
        }
    }

    @PostMapping("/type")
    public ResponseEntity<?> getPostByType(@RequestBody Post type) {
        try {
            List<Post> posts = postService.getPostByType(type.getType());
            return ResponseEntity.ok(posts);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve posts by type: " + e.getMessage());
        }
    }

    @GetMapping("/{id}/images")
    public ResponseEntity<byte[]> getImagesByPostId(@PathVariable Long id) {
        try {
            Post post = postService.getPostByID(id);
            if (post != null && post.getImages() != null && !post.getImages().isEmpty()) {
                String imageName = post.getImages().get(0); // Assuming you only want to return the first image
                String imagePath = "uploads/" + imageName; // Construct the relative path

                Path path = Paths.get(imagePath);
                if (Files.exists(path)) {
                    byte[] imageData = Files.readAllBytes(path);

                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.IMAGE_PNG); // Adjust content type as needed based on the image type

                    return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found for the post".getBytes());
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Images not found for the post".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(("Failed to retrieve images: " + e.getMessage()).getBytes());
        }
    }
}
