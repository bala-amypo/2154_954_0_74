package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Studentity;
import com.example.demo.service.Studservice;

@RestController
@RequestMapping("/student")
public class Studctl {

    private final Studservice service;

    public Studctl(Studservice service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Studentity add(@RequestBody Studentity s) {
        return service.save(s);
    }

    @GetMapping("/all")
    public List<Studentity> getAll() {
        return service.getAll();
    }
}
