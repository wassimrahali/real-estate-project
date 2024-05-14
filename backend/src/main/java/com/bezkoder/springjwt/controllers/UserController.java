package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;


    @PostMapping
    public User saveUser(@RequestBody User user){
        return service.saveuser(user);
    }
    @GetMapping("/{id}")
    public User getuser(@PathVariable Long id) throws Exception {
        return service.getSudentByID(id);
    }
    @GetMapping
    public List<User> getAllUser(){
        return service.getAlluser();
    }



    @DeleteMapping("/{id}")
    public String deleteuser(@PathVariable Long id) throws Exception {
        service.deleteuserByID(id);
        return "user delete successfully";
    }
    @PutMapping
    public User updateuser(@RequestBody User user) throws Exception {
        return service.updateuser(user);

    }
}