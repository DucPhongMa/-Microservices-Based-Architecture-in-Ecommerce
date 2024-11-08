package com.ducphong.user_service.controller;


import com.ducphong.user_service.kafka.UserKafkaProducer;
import com.ducphong.user_service.model.User;
import com.ducphong.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserKafkaProducer userKafkaProducer;

    @PostMapping("/api/user")
    public String registerUser(@RequestBody User user){
        ResponseEntity<?> userCreatedResponse = userService.registerUser(user);
        if (userCreatedResponse.getStatusCode().is2xxSuccessful() && userCreatedResponse.getBody() != null) {
            User createdUser = (User) userCreatedResponse.getBody();

            userKafkaProducer.sendMessage(createdUser);
            return "User created!!!";
        }

        return "Failed to create user.";
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<?> fetchUserById(@PathVariable String id) {
        return userService.fetchUserById(id);
    }


    @GetMapping("/api/users")
    public ResponseEntity<?> fetchUsers() {
        return userService.fetchUsers();
    }
}