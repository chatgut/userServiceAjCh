package com.example.userserviceajch.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> createUser(UserEntity user) {
        if (user != null) {
            userRepository.save(user);
            return ResponseEntity.ok("User created successfully");
        } else {
            return ResponseEntity.badRequest().body("User not created");
        }
    }

    public Optional<UserEntity> getUser(Long id) {
        return Optional.of(userRepository.findById(id).get());
    }

    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<String> updateUser(Long id, UserEntity updatedUser) {
    UserEntity user = userRepository.findById(id).get();
    if (user != null) {
        user.setUserName(updatedUser.getUserName());
        user.setImageUrl(updatedUser.getImageUrl());
        userRepository.save(user);
        return ResponseEntity.ok("User updated successfully");
    }else{
        return ResponseEntity.badRequest().body("User not updated");
    }
    }
    public ResponseEntity<String> deleteUser(Long id) {
       UserEntity user = userRepository.findById(id).get();
       if (user != null){
           userRepository.delete(user);
           return ResponseEntity.ok("User deleted successfully");
       }else{
           return ResponseEntity.badRequest().body("User not found");
       }
    }
}
