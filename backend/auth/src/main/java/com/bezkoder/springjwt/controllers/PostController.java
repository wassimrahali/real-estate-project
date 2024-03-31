package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.entity;
import com.bezkoder.springjwt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService service;

    @PostMapping
    public ResponseEntity<entity.Post> savePost(@RequestBody entity.Post post){
        entity.Post savedPost = service.savePost(post);
        return ResponseEntity.ok(savedPost);
    }

    @GetMapping("/{id}")
    public ResponseEntity<entity.Post> getPost(@PathVariable Long id) {
        try {
            entity.Post post = service.getPostByID(id);
            return ResponseEntity.ok(post);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<entity.Post>> getAllPost(){
        List<entity.Post> posts = service.getAllPost();
        return ResponseEntity.ok(posts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Long id) {
        try {
            service.deletePostByID(id);
            return ResponseEntity.ok("Post deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete post");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<entity.Post> updatePost(@PathVariable Long id, @RequestBody entity.Post post) {
        try {
            entity.Post updatedPost = service.updatePost(id, post);
            return ResponseEntity.ok(updatedPost);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
