package com.carrental.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    public List<String> getVehicles() {
        return List.of("BMW", "Audi", "Mercedes");
    }

    public String getVehicle(int id) {
        return "BMW";
    }
}
