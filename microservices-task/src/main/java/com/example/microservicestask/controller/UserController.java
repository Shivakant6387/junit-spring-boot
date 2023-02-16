package com.example.microservicestask.controller;

import com.example.microservicestask.model.User;
import com.example.microservicestask.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;
    //get
        @GetMapping("/users")
    public List<User> getAllUser(User userModel){
            return userService.getAllUser(userModel);
        }
    @GetMapping("/user/{id}")
    public Optional<User>findById(@PathVariable Integer id){
        return userService.findById(id);
    }
        //post
        @PostMapping("/createUser")
    public User createUsers(@RequestBody User userModel){
            return userService.createUser(userModel);
    }
    //update
    @PutMapping("/update")
    public User updateUser(@RequestBody User userModel){
            return userService.updateUser(userModel);
    }
}
