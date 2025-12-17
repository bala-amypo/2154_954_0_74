package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Studentity;

public interface Studservice {

    Studentity save(Studentity s);

    List<Studentity> getAll();

    Optional<Studentity> getById(Long id);
}
