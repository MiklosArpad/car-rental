package com.carrental.mapper;

import com.carrental.model.Make;
import com.carrental.resource.MakeWithVehiclesResponseResource;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MakeWithVehiclesToResourceMapper implements Mapper<Make, MakeWithVehiclesResponseResource> {

    private final VehicleWithoutMakeToResourceMapper toResourceMapper;

    public MakeWithVehiclesToResourceMapper(VehicleWithoutMakeToResourceMapper toResourceMapper) {
        this.toResourceMapper = toResourceMapper;
    }

    @Override
    public MakeWithVehiclesResponseResource map(Make make) {
        var makeResource = new MakeWithVehiclesResponseResource();

        makeResource.setId(make.getId());
        makeResource.setName(make.getName());

        var vehiclesWithoutMake = make.getVehicles().stream()
                .map(toResourceMapper::map)
                .collect(Collectors.toList());

        makeResource.setVehicles(vehiclesWithoutMake);

        return makeResource;
    }
}
