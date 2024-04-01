package com.bezkoder.springjwt.controllers;
import com.bezkoder.springjwt.models.Post;
import com.bezkoder.springjwt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService service;


    /*@GetMapping("/images/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {
        byte[] imageData = service.getImageData(imageName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // Or MediaType.IMAGE_PNG, etc.
        headers.setContentLength(imageData.length);
        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
    }*/
    @PostMapping
    public Post savePost(@RequestBody Post post){
        System.out.println("hello");
        return service.savePost(post);
    }
    @GetMapping("/{id}")
    public Post getPost(@PathVariable Long id) throws Exception {
        return service.getPostByID(id);
    }
    @GetMapping
    public List<Post> getAllPost(){
        return  service.getAllPost();
    }
    @DeleteMapping("/{id}")
    public String deletePostById(@PathVariable Long id) throws Exception {
        service.deletePostByID(id);
        return "Post delete successfully";
    }
    @PutMapping
    public Post updatePost(@RequestBody Post post) throws Exception {
        return service.updatePost(post);

    }
    @PostMapping("/type")
    public List<Post> getPostByType(@RequestBody Post type) throws Exception {
        return service.getPostByType(type.getType());
    }
}
