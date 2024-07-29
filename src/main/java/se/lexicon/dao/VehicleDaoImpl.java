package se.lexicon.dao;

import se.lexicon.model.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class VehicleDaoImpl implements VehicleDao {

    private List<Vehicle> storage = new ArrayList<>();

    @Override
    public Optional<Vehicle> find(String licensePlate, int customerId) {
        // todo: needs completion
        return Optional.empty();
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        // todo: needs completion
        return null;
    }

    @Override
    public boolean remove(String licensePlate, int customerId) {
        // todo: needs completion
        return false;
    }

    @Override
    public void update(Vehicle vehicle) {
        // todo: needs completion
    }

    @Override
    public Collection<Vehicle> findByCustomerId(int customerId) {
        // todo: needs completion
        return null;
    }
}
