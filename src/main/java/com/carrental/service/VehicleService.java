package com.carrental.service;

import com.carrental.exception.VehicleNotFoundException;
import com.carrental.model.Vehicle;
import com.carrental.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicle(Long id) {
        var vehicle = vehicleRepository.findById(id);

        if (vehicle.isPresent()) {
            return vehicle.get();
        }

        throw new VehicleNotFoundException();
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        var vehicleToUpdate = vehicleRepository.findById(id);

        if (vehicleToUpdate.isEmpty()) {
            throw new VehicleNotFoundException();
        }

        vehicleToUpdate.get().update(vehicle);

        return vehicleRepository.save(vehicleToUpdate.get());
    }

    public void deleteVehicle(Long id) {
        var vehicleToDelete = vehicleRepository.findById(id);

        if (vehicleToDelete.isEmpty()) {
            throw new VehicleNotFoundException();
        }

        vehicleRepository.deleteById(id);
    }
}
