package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserService {
    @Autowired
    UserRepository respository;
    public User saveuser(User user){
        User saveuser=respository.save(user);
        System.out.println(saveuser);
        return saveuser;
    }
    public User getSudentByID(Long id) throws Exception {
        return respository.findById(id).orElseThrow(()-> new Exception("user no found where id: "+id));
    }
    public List<User> getAlluser(){
        return respository.findAll();
    }
    public void deleteuserByID(Long id) throws Exception {
        respository.findById(id).orElseThrow(()-> new Exception("user no found with id: "+id));
        respository.deleteById(id);
        System.out.println("user deleted with id : "+id);

    }

    public User updateuser(User user) throws Exception {
        respository.findById(user.getId()).orElseThrow(()-> new Exception("user no found with id: "+user.getId()));
        return respository.save(user);
    }
}
