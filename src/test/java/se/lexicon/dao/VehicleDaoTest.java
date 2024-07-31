package se.lexicon.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Customer;
import se.lexicon.model.Vehicle;
import se.lexicon.model.VehicleType;

import java.util.Collection;
import java.util.Optional;

public class VehicleDaoTest {

    private VehicleDao testObject;

    @BeforeEach
    public void setup() {
        testObject = new VehicleDaoImpl();

        Vehicle expectedVehicle = new Vehicle("ABC123", VehicleType.CAR, new Customer(1, "John", "Doe"));
        Vehicle actualVehicle = testObject.create(expectedVehicle); // new Vehicle("ABC123", VehicleType.CAR, new Customer(1, "John", "Doe"));
        Assertions.assertNotNull(actualVehicle);
        Assertions.assertEquals(expectedVehicle.getLicensePlate(), actualVehicle.getLicensePlate()); // true
        Assertions.assertEquals(expectedVehicle, actualVehicle);
    }

    @Test
    public void testFind_existingVehicle() {
        Optional<Vehicle> optionalVehicle = testObject.find("ABC123", 1);
        Assertions.assertTrue(optionalVehicle.isPresent()); // true
    }


    @Test
    public void testFind_nonExistingVehicle() {
        Optional<Vehicle> optionalVehicle = testObject.find("AAA123", 1);
        Assertions.assertFalse(optionalVehicle.isPresent());
    }

    @Test
    public void testFindByCustomerId() {
        Collection<Vehicle> vehicles = testObject.findByCustomerId(1);
        Assertions.assertEquals(1, vehicles.size());
    }

    @Test
    public void testFindByNonExistingCustomerId() {
        Collection<Vehicle> vehicles = testObject.findByCustomerId(10);
        Assertions.assertEquals(0, vehicles.size());
    }


    // add more tests as needed.
}
