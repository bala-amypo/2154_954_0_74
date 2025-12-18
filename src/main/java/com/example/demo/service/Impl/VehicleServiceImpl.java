package com.example.demo.service.impl;

import com.example.demo.entity.UserEntity;
import com.example.demo.entity.VehicleEntity;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.VehicleRepo;
import com.example.demo.service.VehicleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ⭐ VERY IMPORTANT
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public VehicleEntity addVehicle(Long userId, VehicleEntity vehicle) {

        // capacity validation
        if (vehicle.getCapacityKg() <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }

        UserEntity user = userRepo.findById(userId)
                .orElseThrow(() ->
                        new EntityNotFoundException("User not found"));

        vehicle.setUser(user);

        return vehicleRepo.save(vehicle);
    }

    @Override
    public List<VehicleEntity> getVehiclesByUser(Long userId) {
        return vehicleRepo.findByUserId(userId);
    }

    @Override
    public VehicleEntity findById(Long id) {
        return vehicleRepo.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Vehicle not found"));
    }
}
