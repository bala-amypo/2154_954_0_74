package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Studentity;
import com.example.demo.repository.StudRepo;
import com.example.demo.service.Studservice;

@Service
public class StudServiceImpl implements Studservice {

    private final StudRepo repo;

    public StudServiceImpl(StudRepo repo) {
        this.repo = repo;
    }

    @Override
    public Studentity save(Studentity s) {
        return repo.save(s);
    }

    @Override
    public List<Studentity> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Studentity> getById(Long id) {
        return repo.findById(id); // uses Optional.ofNullable internally
    }
}
