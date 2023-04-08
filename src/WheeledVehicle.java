package src;

import java.util.Date;

public class WheeledVehicle extends Vehicle{

    private int amountWheels;

    public WheeledVehicle(int seatsForPeople, int maxSpeed, int amountWheels) {
        super(seatsForPeople, maxSpeed);
        this.amountWheels = amountWheels;
    }

    public WheeledVehicle(int seatsForPeople, int maxSpeed, Date dateReleased, int amountWheels) {
        super(seatsForPeople, maxSpeed, dateReleased);
        this.amountWheels = amountWheels;
    }

    public int getAmountWheels() {
        return amountWheels;
    }

    public void setAmountWheels(int amountWheels) {
        this.amountWheels = amountWheels;
    }

    @Override
    public void go() {
        System.out.println("Wheels go round! Shhhhh...");
    }

    public void changeTires() {
        System.out.println("The tires was successfully changed.");
    }
}
