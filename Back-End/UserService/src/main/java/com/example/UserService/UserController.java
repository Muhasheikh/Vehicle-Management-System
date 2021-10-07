/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lahiru Yapa
 */
@CrossOrigin
@RestController
public class UserController {
    
    @Autowired
    private UserRepository userRepository; 
    
    
    @GetMapping(path = "/users/{userReferenceId}")
    public User getUserByRef(@PathVariable String userReferenceId){
        return userRepository.findByUserReferenceId(userReferenceId);
    }  
    
    @PostMapping(path = "/users")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }   
    
    @PutMapping(path = "/users/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user){
        user.setId(id);
        userRepository.save(user);
    }    
}
