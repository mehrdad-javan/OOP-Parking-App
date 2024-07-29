package se.lexicon;


import se.lexicon.model.*;

public class App {
    public static void main(String[] args) {

        ParkingSpot parkingSpot1 = new ParkingSpot(1, false, 47001);
        Customer customer1 = new Customer(1, "Customer Name", "123456789");
        System.out.println(parkingSpot1);
        System.out.println(customer1);
        Vehicle vehicle1 = new Vehicle("abc123", VehicleType.ELECTRIC, customer1);
        System.out.println(vehicle1);

        Reservation reservation1 = new Reservation(2, vehicle1, parkingSpot1);
        reservation1.create();
        System.out.println(customer1);
        System.out.println(parkingSpot1);
        System.out.println(reservation1);



    }
}
