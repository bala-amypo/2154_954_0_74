package com.example.demo.service.impl;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service   // ⭐ VERY IMPORTANT
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    private final BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    @Override
    public UserEntity register(UserEntity user) {

        // encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // default role
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }

        return userRepo.save(user);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() ->
                        new EntityNotFoundException("User not found"));
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("User not found"));
    }
}
