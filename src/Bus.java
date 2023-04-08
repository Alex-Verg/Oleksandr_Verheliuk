package src;

import java.util.Date;

public class Bus extends WheeledVehicle{

    private int busNumber;

    public Bus(int seatsForPeople, int maxSpeed, int amountWheels, int busNumber) {
        super(seatsForPeople, maxSpeed, amountWheels);
        this.busNumber = busNumber;
    }

    public Bus(int seatsForPeople, int maxSpeed, Date dateReleased, int amountWheels) {
        super(seatsForPeople, maxSpeed, dateReleased, amountWheels);
    }

    public Bus(int seatsForPeople, int maxSpeed, Date dateReleased, int amountWheels, int busNumber) {
        super(seatsForPeople, maxSpeed, dateReleased, amountWheels);
        this.busNumber = busNumber;
    }

    public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    @Override
    public void go() {
        System.out.println("The Bus starts working on the route " + this.busNumber);
    }

    public void sellTickets() {
        System.out.println("All passengers has tickets now.");
    }

    public void stopBus() {
        System.out.println("Dear passengers, there is a bus stop here. Please come in and out quickly. Do not delay the departure of the bus.");
    }
}
