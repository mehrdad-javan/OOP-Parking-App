package se.lexicon.model;

public class Customer {

    private int id;
    private String name;
    private String phoneNumber;
    private Reservation reservation;

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Customer(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Customer(int id, String name, String phoneNumber, Reservation reservation) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.reservation = reservation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Customer Id: ").append(id)
                .append(", Name: ").append(name)
                .append(", PhoneNumber: ").append(phoneNumber);
        if (reservation != null) {
            sb.append(", Reservation Id: ").append(reservation.getId());
        }

        return sb.toString();

    }
}
