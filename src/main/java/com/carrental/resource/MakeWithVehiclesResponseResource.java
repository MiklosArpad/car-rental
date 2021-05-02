package com.carrental.resource;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class MakeWithVehiclesResponseResource implements Serializable {
    private Long id;
    private String name;
    private List<VehicleWithoutMakeResponseResource> vehicles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VehicleWithoutMakeResponseResource> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleWithoutMakeResponseResource> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MakeWithVehiclesResponseResource that = (MakeWithVehiclesResponseResource) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(vehicles, that.vehicles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, vehicles);
    }
}
