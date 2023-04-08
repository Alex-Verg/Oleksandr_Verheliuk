package src;

import java.util.Date;

public class Plane extends Vehicle{

    private float wingspan;
    private boolean isActiveTransmitter = false;

    public Plane(int seatsForPeople, int maxSpeed, float wingspan) {
        super(seatsForPeople, maxSpeed);
        this.wingspan = wingspan;
    }

    public Plane(int seatsForPeople, int maxSpeed, Date dateReleased, float wingspan) {
        super(seatsForPeople, maxSpeed, dateReleased);
        this.wingspan = wingspan;
    }

    public float getWingspan() {
        return wingspan;
    }

    public void setWingspan(float wingspan) {
        this.wingspan = wingspan;
    }

    public boolean isActiveTransmitter() {
        return isActiveTransmitter;
    }

    public void setActiveTransmitter(boolean activeTransmitter) {
        isActiveTransmitter = activeTransmitter;
    }

    @Override
    public void go() {
        System.out.println("The Plane is flying!");
    }

    public void checkEngines() {
        System.out.println("The Plane is checking the engines before the flight.");
    }

    public void turnOnTransmitter() {
        setActiveTransmitter(true);
    }

    public void turnOfTransmitter() {
        setActiveTransmitter(false);
    }
}
