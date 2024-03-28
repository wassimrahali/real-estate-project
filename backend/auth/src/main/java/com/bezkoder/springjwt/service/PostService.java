package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.Post;
import com.bezkoder.springjwt.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
@Autowired
    PostRepository repository;

  /*  private static final String IMAGE_DIRECTORY = "../images/";


    public byte[] getImageData(String imageName) {
        Path imagePath = Paths.get(IMAGE_DIRECTORY + imageName);
        try {
            return Files.readAllBytes(imagePath);
        } catch (IOException e) {
            e.printStackTrace();
            // You may want to handle this exception appropriately
            return null;
        }
    }*/
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
}
