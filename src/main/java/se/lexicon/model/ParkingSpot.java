package se.lexicon.model;

public class ParkingSpot {

    private int spotNumber;
    private boolean occupied;
    private int areaCode;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public ParkingSpot(int spotNumber, boolean occupied, int areaCode) {
        this.spotNumber = spotNumber;
        this.occupied = occupied;
        this.areaCode = areaCode;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public void occupy(){
        this.occupied = true;
    }
    public void vacate(){
        this.occupied = false;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotNumber=" + spotNumber +
                ", occupied=" + occupied +
                ", areaCode=" + areaCode +
                '}';
    }
}
