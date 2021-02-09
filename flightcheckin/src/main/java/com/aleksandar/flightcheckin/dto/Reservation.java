package com.aleksandar.flightcheckin.dto;





public class Reservation {
    private Long id;
    private Boolean checkedIn;
    private int numberOfBags;
    private Passenger passenger;
    private Flight flight;


    public Long getId() {
        return id;
    }

    public Reservation setId(Long id) {
        this.id = id;
        return this;
    }

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
