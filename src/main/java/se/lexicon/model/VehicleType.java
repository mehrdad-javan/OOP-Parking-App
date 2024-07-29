package se.lexicon.model;

public enum VehicleType {
    CAR(1, "Car"),
    MOTORCYCLE(2, "Motorcycle"),
    TRUCK(3, "Truck"),
    VAN(4, "Van"),
    ELECTRIC(5, "EL"),
    OTHER(6, "Other");

    private final int code;
    private final String name;

    VehicleType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
