package se.lexicon.dao;

import se.lexicon.model.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class VehicleDaoImpl implements VehicleDao {

    private List<Vehicle> storage = new ArrayList<>(); // v1, v2

    @Override
    public Optional<Vehicle> find(String licensePlate, int customerId) {
        for (Vehicle vehicle : storage) {
            if (vehicle.getLicensePlate().equals(licensePlate) && vehicle.getCustomer().getId() == customerId) {
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();

    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        for (Vehicle vehicleElement : storage) {
            if (vehicleElement.getLicensePlate().equalsIgnoreCase(vehicle.getLicensePlate())
                    && vehicleElement.getCustomer().getId() == vehicle.getCustomer().getId()) {
                throw new IllegalArgumentException("Vehicle already exists.");
            }
        }
        storage.add(vehicle);
        return vehicle;
    }

    @Override
    public boolean remove(String licensePlate, int customerId) {
        Optional<Vehicle> optionalVehicle = find(licensePlate, customerId);
        if (optionalVehicle.isPresent()) {
            storage.remove(optionalVehicle.get());
            return true;
        }
        return false;
    }

    @Override
    public void update(Vehicle vehicle) {
        for (Vehicle vehicleElement : storage) {
            if (vehicleElement.getLicensePlate().equalsIgnoreCase(vehicle.getLicensePlate())
                    && vehicleElement.getCustomer().getId() == vehicle.getCustomer().getId()) {
                vehicleElement.setType(vehicle.getType());
                break;
            }
        }
    }

    @Override
    public Collection<Vehicle> findByCustomerId(int customerId) {
        List<Vehicle> foundVehicles = new ArrayList<>();
        for (Vehicle vehicle : storage) {
            if (vehicle.getCustomer().getId() == customerId) {
                foundVehicles.add(vehicle);
            }
        }
        return foundVehicles;
    }

}
