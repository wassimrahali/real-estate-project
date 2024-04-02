package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Post;
import com.bezkoder.springjwt.services.FileStorageService;
import com.bezkoder.springjwt.services.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
            // Assuming your Post object is passed as JSON in the 'post' parameter
            Post post = new ObjectMapper().readValue(postJson, Post.class);

            // Save the post with images
            post.setImages(saveImages(files));

            Post savedPost = postService.savePost(post);
            return ResponseEntity.ok(savedPost); // Return saved post
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save post: " + e.getMessage()); // Return error message
        }
    }

    // Method to save images to the server
    private List<String> saveImages(MultipartFile[] files) {
        List<String> imageUrls = new ArrayList<>();
        for (MultipartFile file : files) {
            try {
                // Save file to storage using FileStorageService
                String imageUrl = fileStorageService.saveFile(file);
                imageUrls.add(imageUrl);
                System.out.println(imageUrl);
            } catch (Exception e) {
                // Handle exception appropriately
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
                return ResponseEntity.ok(post); // Return post if found
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found"); // Return 404 if post not found
            }
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve post: " + e.getMessage()); // Return error message
        }
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPost() {
        try {
            List<Post> posts = postService.getAllPost();
            return ResponseEntity.ok(posts); // Return list of posts
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Return error message
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Long id) {
        try {
            postService.deletePostByID(id);
            return ResponseEntity.ok("Post deleted successfully"); // Return success message
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete post: " + e.getMessage()); // Return error message
        }
    }

    @PutMapping
    public ResponseEntity<?> updatePost(@RequestBody Post post) {
        try {
            Post updatedPost = postService.updatePost(post);
            if (updatedPost != null) {
                return ResponseEntity.ok(updatedPost); // Return updated post
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found"); // Return 404 if post not found
            }
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update post: " + e.getMessage()); // Return error message
        }
    }

    @PostMapping("/type")
    public ResponseEntity<?> getPostByType(@RequestBody Post type) {
        try {
            List<Post> posts = postService.getPostByType(type.getType());
            return ResponseEntity.ok(posts); // Return list of posts by type
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve posts by type: " + e.getMessage()); // Return error message
        }
    }
}
