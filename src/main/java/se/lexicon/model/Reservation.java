package se.lexicon.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Reservation {
    private String id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Vehicle associatedVehicle;
    private ParkingSpot parkingSpot;

    public Reservation(int hours, Vehicle associatedVehicle, ParkingSpot parkingSpot) {
        this.startTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.endTime = this.startTime.plusHours(hours).truncatedTo(ChronoUnit.SECONDS);
        this.associatedVehicle = associatedVehicle;
        this.parkingSpot = parkingSpot;
    }

    public Reservation(String id, LocalDateTime startTime, LocalDateTime endTime, Vehicle associatedVehicle, ParkingSpot parkingSpot) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.associatedVehicle = associatedVehicle;
        this.parkingSpot = parkingSpot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime.truncatedTo(ChronoUnit.SECONDS);

    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime.truncatedTo(ChronoUnit.SECONDS);
    }

    public Vehicle getAssociatedVehicle() {
        return associatedVehicle;
    }

    public void setAssociatedVehicle(Vehicle associatedVehicle) {
        this.associatedVehicle = associatedVehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public void extendTime(int hours) {
        this.endTime = this.endTime.plusHours(hours).truncatedTo(ChronoUnit.SECONDS);
    }

    public void create() {
        if (parkingSpot == null) throw new IllegalArgumentException("ParkingSpot should not be null.");
        if (associatedVehicle == null) throw new IllegalArgumentException("AssociatedVehicle should not be null.");

        this.id = UUID.randomUUID().toString();
        this.parkingSpot.occupy();
        this.associatedVehicle.getCustomer().setReservation(this);
    }

    public void cancel() {
        if (parkingSpot == null) throw new IllegalArgumentException("ParkingSpot should not be null.");
        if (associatedVehicle == null) throw new IllegalArgumentException("AssociatedVehicle should not be null.");

        parkingSpot.vacate();
        associatedVehicle.getCustomer().setReservation(null);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", associatedVehicle=" + associatedVehicle.getLicensePlate() +
                ", parkingSpot=" + parkingSpot.getSpotNumber() +
                '}';
    }
}
