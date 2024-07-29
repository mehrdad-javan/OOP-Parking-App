package se.lexicon.model;

public class Vehicle {
    private String licensePlate;
    private VehicleType type;
    private Customer customer;

    public Vehicle(String licensePlate) {
        this(licensePlate, null);
    }

    public Vehicle(String licensePlate, VehicleType type) {
        setLicensePlate(licensePlate);
        setType(type);
    }

    public Vehicle(String licensePlate, VehicleType type, Customer customer) {
        this(licensePlate, type);
        setCustomer(customer);
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            throw new IllegalArgumentException("LicensePlace should not be null or empty.");
        }
        this.licensePlate = licensePlate;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        if (type == null) {
            type = VehicleType.CAR;
        }
        this.type = type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer should not be null.");
        }
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", type=" + type.getName() +
                '}';
    }
}
