package com.carrental.controller;

import com.carrental.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // GET: api/vehicles
    @GetMapping
    public List<String> getVehicles() {
        return vehicleService.getVehicles();
    }

    // GET: api/vehicles/1
    @GetMapping(path = "/{id}")
    public String getVehicles(@PathVariable int id) {
        return vehicleService.getVehicle(id);
    }
}
