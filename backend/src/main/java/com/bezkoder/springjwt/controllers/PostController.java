package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Post;
import com.bezkoder.springjwt.services.FileStorageService;
import com.bezkoder.springjwt.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
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
    public ResponseEntity<?> savePost(@RequestParam("title") String title,
                                      @RequestParam("prix") int prix,
                                      @RequestParam("type") String type,
                                      @RequestParam("description") String description,
                                      @RequestParam("lieu") String lieu,
                                      @RequestParam("imageFiles") MultipartFile[] imageFiles,
                                      @RequestParam("typeDeTransaction") String typeDeTransaction,
                                      @RequestParam("superficie") int superficie,
                                      @RequestParam("sallesDeBains") int sallesDeBains,
                                      @RequestParam("chambres") int chambres,
                                      @RequestParam("user_id") int user_id) {
        try {
            // Save images and get the list of image URLs
            List<String> images = saveImages(imageFiles);

            // Create a new Post object
            Post post = new Post();
            post.setTitle(title);
            post.setPrix(prix);
            post.setType(type);
            post.setDescription(description);
            post.setLieu(lieu);
            post.setImages(images);
            post.setTypeDeTransaction(typeDeTransaction);
            post.setSuperficie(superficie);
            post.setSallesDeBains(sallesDeBains);
            post.setChambres(chambres);
            post.setUser_id(user_id);

            // Save the post
            Post savedPost = postService.savePost(post);

            // Return the saved post with OK status
            return ResponseEntity.ok(savedPost);
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save post: " + e.getMessage());
        }
    }



    private List<String> saveImages(MultipartFile[] files) {
        List<String> imageUrls = new ArrayList<>();
        for (MultipartFile file : files) {
            try {
                // Save file to storage using FileStorageService
                String imageUrl = fileStorageService.saveFile(file);
                imageUrls.add(imageUrl);
                System.out.println("Image URL: " + imageUrl);
            } catch (IOException e) {
                // Handle IO exception
                e.printStackTrace();
            } catch (Exception e) {
                // Handle other exceptions
                e.printStackTrace();
            }
        }
        return imageUrls;
    }

    // Method to save images to the server
    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id) {
        try {
            Post post = postService.getPostByID(id);
            if (post != null) {
                return ResponseEntity.ok(post); // Return post if found
            } else {
                return ResponseEntity.notFound().build(); // Return 404 if post not found
            }
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to retrieve post: " + e.getMessage()); // Return error message
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
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList()); // Return an empty list if error occurs
        }
    }

    @GetMapping(value = "/{id}/images", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImagesByPostId(@PathVariable Long id) {
        try {
            Post post = postService.getPostByID(id);
            if (post != null && post.getImages() != null && !post.getImages().isEmpty()) {
                String imageName = post.getImages().get(0); // Assuming you only want to return the first image
                String imagePath = "uploads/" + imageName; // Construct the relative path
                Path path = Paths.get(imagePath);
                if (Files.exists(path)) {
                    byte[] imageData = Files.readAllBytes(path);
                    return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageData);
                } else {
                    return ResponseEntity.notFound().build(); // Return 404 if image file not found
                }
            } else {
                return ResponseEntity.notFound().build(); // Return 404 if post or images not found
            }
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(("Failed to retrieve images: " + e.getMessage()).getBytes());
        }
    }

    @GetMapping(value = "/uploads/{imageName:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
        Path imagePath = Paths.get("uploads", imageName);
        byte[] imageData = Files.readAllBytes(imagePath);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageData);
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

    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAllPosts() {
        try {
            postService.deleteAllPosts();
            return ResponseEntity.ok("All posts deleted successfully"); // Return success message
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete all posts: " + e.getMessage()); // Return error message
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