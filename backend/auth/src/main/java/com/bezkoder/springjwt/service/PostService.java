package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.entity;
import com.bezkoder.springjwt.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public entity.Post savePost(entity.Post post){
        return repository.save(post);
    }

    public List<entity.Post> getAllPost(){
        return repository.findAll();
    }

    public entity.Post getPostByID(Long id) throws Exception {
        Optional<entity.Post> optionalPost = repository.findById(id);
        if (optionalPost.isPresent()) {
            return optionalPost.get();
        } else {
            throw new Exception("Post not found with id: " + id);
        }
    }

    public void deletePostByID(Long id) throws Exception {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new Exception("Post not found with id: " + id);
        }
    }

    public entity.Post updatePost(Long id, entity.Post post) throws Exception {
        if (repository.existsById(id)) {
            post.setId(id);
            return repository.save(post);
        } else {
            throw new Exception("Post not found with id: " + id);
        }
    }
}
