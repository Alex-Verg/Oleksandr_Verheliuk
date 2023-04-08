package src;

import java.util.Date;

public abstract class Vehicle {
    private int seatsForPeople;
    private int maxSpeed;
    private Date dateReleased;

    public Vehicle(int seatsForPeople, int maxSpeed) {
        this.seatsForPeople = seatsForPeople;
        this.maxSpeed = maxSpeed;
        this.dateReleased = new Date();
    }

    public Vehicle(int seatsForPeople, int maxSpeed, Date dateReleased) {
        this.seatsForPeople = seatsForPeople;
        this.maxSpeed = maxSpeed;
        this.dateReleased = dateReleased;
    }

    public int getSeatsForPeople() {
        return seatsForPeople;
    }

    public void setSeatsForPeople(int seatsForPeople) {
        this.seatsForPeople = seatsForPeople;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Date getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(Date dateReleased) {
        this.dateReleased = dateReleased;
    }

    public abstract void go();
}