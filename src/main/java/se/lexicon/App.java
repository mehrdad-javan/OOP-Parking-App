package se.lexicon;


import se.lexicon.dao.VehicleDaoImpl;
import se.lexicon.model.Customer;
import se.lexicon.model.Vehicle;
import se.lexicon.model.VehicleType;

import java.util.Optional;

public class App {
    public static void main(String[] args) {

        Customer customer1 = new Customer(1, "John", "Doe");

        Vehicle vehicle1 = new Vehicle("ABC123", VehicleType.CAR, customer1);
        Vehicle vehicle2 = new Vehicle("DEF456", VehicleType.MOTORCYCLE, customer1);


        VehicleDaoImpl vehicleDao = new VehicleDaoImpl();
        vehicleDao.create(vehicle1);
        vehicleDao.create(vehicle2);

        Optional<Vehicle> optionalVehicle = vehicleDao.find("ABC123", 1);
        if (optionalVehicle.isPresent()) {
            System.out.println("Vehicle found: " + optionalVehicle.get());
        } else {
            System.out.println("Vehicle not found.");
        }


    }
}
