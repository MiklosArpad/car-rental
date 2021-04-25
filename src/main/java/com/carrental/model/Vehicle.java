package com.carrental.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "make_id")
    private Make make;

    private String model;
    private String color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void update(Vehicle vehicle) {
        this.licensePlate = vehicle.licensePlate;
        this.color = vehicle.color;
        this.model = vehicle.model;
        this.make = vehicle.make;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        var vehicle = (Vehicle) o;

        return Objects.equals(id, vehicle.id) &&
                Objects.equals(licensePlate, vehicle.licensePlate) &&
                Objects.equals(make, vehicle.make) &&
                Objects.equals(model, vehicle.model) &&
                Objects.equals(color, vehicle.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, licensePlate, make, model, color);
    }
}
