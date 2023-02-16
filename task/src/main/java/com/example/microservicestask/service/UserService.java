package com.example.microservicestask.service;

import com.example.microservicestask.model.User;
import com.example.microservicestask.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public List<User> getAllUser(){

        return userRepository.findAll();
    }
    public User createUser(User userModel){
        return userRepository.save(userModel);
    }
    public Optional<User> findById( Integer id){

        return userRepository.findById(id);

    }
    public User updateUser(User userModel){
        Optional<User> userExisting=findById(userModel.getId());
        userExisting.isPresent();
        User user=userExisting.get();
        user.setId(userModel.getId());
        user.setEmailAddress(userModel.getEmailAddress());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        return userRepository.save(user);
        }
}
