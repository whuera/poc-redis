package com.app.pocredis.controller;

import com.app.pocredis.dto.User;
import com.app.pocredis.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {
    private UserRepository userRepository;

    public
    UserController (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public Map<String, User > findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public
    User findById(@PathVariable String id) {
        return userRepository.findById( id);
    }

    @PostMapping("/users")
    public void createStudent(@RequestBody User user) {
        userRepository.save( user );
    }

    @DeleteMapping("/users/{id}")
    public void deleteStudent(@PathVariable String id) {
        userRepository.delete( id);
    }
}
