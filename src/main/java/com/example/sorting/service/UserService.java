package com.example.sorting.service;

import com.example.sorting.model.UserSort;
import com.example.sorting.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // For password encryption

    public void registerUser(String username, String password, String email) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Username and password must not be empty");
        }

        if (userRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("Username already exists.");
        }

        String encodedPassword = passwordEncoder.encode(password);
        UserSort newUser = new UserSort(username, encodedPassword, email);
        userRepository.save(newUser);

        System.out.println("User registered successfully: " + username);
    }

    public boolean authenticateUser(String username, String rawPassword) {
        UserSort user = userRepository.findByUsername(username);
        if (user != null) {
            return passwordEncoder.matches(rawPassword, user.getPassword());
        }
        return false;
    }

    public boolean userExists(String username) {
        return userRepository.findByUsername(username) != null;
    }

    public UserSort getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void saveUser(UserSort user) {
        if (user != null && user.getUsername() != null && !user.getUsername().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
    }

    public UserSort getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
