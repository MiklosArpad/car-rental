package com.carrental.service;

import com.carrental.model.Make;
import com.carrental.repository.MakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakeService {
    private final MakeRepository makeRepository;

    @Autowired
    public MakeService(MakeRepository makeRepository) {
        this.makeRepository = makeRepository;
    }

    public List<Make> getMakes() {
        return makeRepository.findAll();
    }
}
