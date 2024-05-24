package com.example.UserServiceAjCh.user;

import org.springframework.http.HttpStatus;
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
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User information is missing");
        }

        // Assuming userRepository has a method to find users by a unique attribute, e.g., username or email
        Optional<UserEntity> existingUser = userRepository.findByUserName(user.getUserName());
        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }

        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    public ResponseEntity<?> getUserById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
        }
    }

    public ResponseEntity<List<UserEntity>> findAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    public ResponseEntity<String> updateUser(Long id, UserEntity updatedUser) {
        Optional<UserEntity> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            UserEntity user = existingUser.get();
            user.setUserName(updatedUser.getUserName());
            user.setImageUrl(updatedUser.getImageUrl());
            userRepository.save(user);
            return ResponseEntity.ok("User updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
        }
    }

    public ResponseEntity<String> deleteUser(Long id) {
        Optional<UserEntity> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            userRepository.delete(existingUser.get());
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
        }
    }
}
