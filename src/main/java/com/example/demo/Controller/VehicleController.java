package com.example.demo.Controller;

import com.example.demo.entity.VehicleEntity;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/add/{userId}")
    public VehicleEntity addVehicle(@PathVariable Long userId,
                                    @RequestBody VehicleEntity vehicle) {
        return vehicleService.addVehicle(userId, vehicle);
    }

    @GetMapping("/user/{userId}")
    public List<VehicleEntity> getByUser(@PathVariable Long userId) {
        return vehicleService.getVehiclesByUser(userId);
    }

    @GetMapping("/{id}")
    public VehicleEntity getVehicle(@PathVariable Long id) {
        return vehicleService.findById(id);
    }
}
