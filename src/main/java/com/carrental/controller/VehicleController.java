package com.carrental.controller;

import com.carrental.model.Vehicle;
import com.carrental.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Vehicle>> getVehicles() {
        return new ResponseEntity<>(vehicleService.getVehicles(), HttpStatus.OK);
    }

    // GET: api/vehicles/1
    @GetMapping(path = "/{id}")
    public ResponseEntity<Vehicle> getVehicles(@PathVariable Long id) {
        try {
            var vehicle = vehicleService.getVehicle(id);
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: api/vehicles
    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        var savedVehicle = vehicleService.saveVehicle(vehicle);
        return new ResponseEntity<>(savedVehicle, HttpStatus.CREATED);
    }

    // PUT: api/vehicles/1
    @PutMapping(path = "/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id,
                                                 @RequestBody Vehicle vehicle) {
        try {
            var updatedVehicle = vehicleService.updateVehicle(id, vehicle);
            return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE: api/vehicles/1
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        try {
            vehicleService.deleteVehicle(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
