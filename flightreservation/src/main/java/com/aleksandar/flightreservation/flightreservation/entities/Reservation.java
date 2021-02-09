package com.aleksandar.flightreservation.flightreservation.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity{
    private Boolean checkedIn;
    private int numberOfBags;
    @OneToOne
    private Passenger passenger;
    @OneToOne
    private Flight flight;



    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public Reservation setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
        return this;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public Reservation setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
        return this;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Reservation setPassenger(Passenger passenger) {
        this.passenger = passenger;
        return this;
    }

    public Flight getFlight() {
        return flight;
    }

    public Reservation setFlight(Flight flight) {
        this.flight = flight;
        return this;
    }
}
