package org.example.notNeedClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Parking {
    private final List<Vehicle> vehicles;
    private final Map<String, Vehicle> vehicleMap;

    @Autowired
    public Parking(List<Vehicle> vehicles, Map<String, Vehicle> vehicleMap) {
        this.vehicles = vehicles;
        this.vehicleMap = vehicleMap;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public Map<String, Vehicle> getVehicleMap() {
        return vehicleMap;
    }
}
