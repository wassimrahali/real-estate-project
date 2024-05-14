package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Post;
import com.bezkoder.springjwt.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository repository;

    public Post savePost(Post post){
        Post savePost=repository.save(post);

        System.out.println(savePost);
        return savePost;
    }
    public List<Post> getAllPost(){
        return repository.findAll();
    }
    public Post getPostByID(Long id) throws Exception {
        return repository.findById(id).orElseThrow(()-> new Exception("Post no found where id: "+id));
    }
    public void deletePostByID(Long id) throws Exception {
        repository.findById(id).orElseThrow(()-> new Exception("Post no found with id: "+id));
        repository.deleteById(id);
        System.out.println("Post deleted with Num : "+id);
    }
    public Post updatePost(Post post) throws Exception {
        repository.findById(post.getId()).orElseThrow(()-> new Exception("Post no found with id: "+post.getId()));
        return repository.save(post);
    }
    public List<Post> getPostByType(String type) throws Exception {
        return repository.findByType(type);
    }
    public void deleteAllPosts() {
        repository.deleteAll();
        System.out.println("All posts deleted");
    }


}

