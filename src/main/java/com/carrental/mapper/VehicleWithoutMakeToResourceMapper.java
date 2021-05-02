package com.carrental.mapper;

import com.carrental.model.Vehicle;
import com.carrental.resource.VehicleWithoutMakeResponseResource;
import org.springframework.stereotype.Component;

@Component
public class VehicleWithoutMakeToResourceMapper implements Mapper<Vehicle, VehicleWithoutMakeResponseResource> {

    @Override
    public VehicleWithoutMakeResponseResource map(Vehicle vehicle) {
        var vehicleResource = new VehicleWithoutMakeResponseResource();

        vehicleResource.setId(vehicle.getId());
        vehicleResource.setLicensePlate(vehicle.getLicensePlate());
        vehicleResource.setModel(vehicle.getModel());
        vehicleResource.setColor(vehicle.getColor());

        return vehicleResource;
    }
}
