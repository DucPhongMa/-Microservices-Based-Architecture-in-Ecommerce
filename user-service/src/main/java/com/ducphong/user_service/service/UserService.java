package com.ducphong.user_service.service;


import com.ducphong.user_service.kafka.UserKafkaProducer;
import com.ducphong.user_service.model.User;
import com.ducphong.user_service.projections.UserProjection;
import com.ducphong.user_service.repository.UserRepository;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<?> registerUser(User user){
        try{
            return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> fetchUserById(String id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No User Found",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> fetchUsers(){
        List<UserProjection> users = userRepository.findAllBy();
        if(!users.isEmpty()){
            return new ResponseEntity<List<UserProjection>>(users, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Users",HttpStatus.NOT_FOUND);
        }
    }
}
