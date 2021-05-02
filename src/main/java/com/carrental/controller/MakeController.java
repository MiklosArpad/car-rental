package com.carrental.controller;

import com.carrental.mapper.MakeToResourceMapper;
import com.carrental.mapper.MakeWithVehiclesToResourceMapper;
import com.carrental.resource.MakeResponseResource;
import com.carrental.resource.MakeWithVehiclesResponseResource;
import com.carrental.service.MakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/makes")
public class MakeController {

    private final MakeService makeService;
    private final MakeWithVehiclesToResourceMapper toResourceMapper;

    @Autowired
    public MakeController(MakeService makeService, MakeWithVehiclesToResourceMapper toResourceMapper) {
        this.makeService = makeService;
        this.toResourceMapper = toResourceMapper;
    }

    @GetMapping
    public ResponseEntity<List<MakeWithVehiclesResponseResource>> getMakes() {
        var makes = makeService.getMakes();

        var makeResources = makes.stream()
                .map(toResourceMapper::map)
                .collect(Collectors.toList());

        return new ResponseEntity<>(makeResources, HttpStatus.OK);
    }
}
