package com.carrental.mapper;

import com.carrental.model.Vehicle;
import com.carrental.resource.VehicleResponseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleToResourceMapper implements Mapper<Vehicle, VehicleResponseResource> {

    private final MakeToResourceMapper toResourceMapper;

    @Autowired
    public VehicleToResourceMapper(MakeToResourceMapper toResourceMapper) {
        this.toResourceMapper = toResourceMapper;
    }

    @Override
    public VehicleResponseResource map(Vehicle vehicle) {
        var vehicleResource = new VehicleResponseResource();

        vehicleResource.setId(vehicle.getId());
        vehicleResource.setLicensePlate(vehicle.getLicensePlate());

        var makeResource = toResourceMapper.map(vehicle.getMake());
        vehicleResource.setMake(makeResource);

        vehicleResource.setModel(vehicle.getModel());
        vehicleResource.setColor(vehicle.getColor());

        return vehicleResource;
    }
}
