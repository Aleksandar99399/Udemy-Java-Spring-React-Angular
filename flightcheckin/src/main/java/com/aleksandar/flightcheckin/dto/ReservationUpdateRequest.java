package com.aleksandar.flightcheckin.dto;

public class ReservationUpdateRequest {

    private Long id;
    private Boolean checkedIn;
    private int numberOfBags;

    public Long getId() {
        return id;
    }

    public ReservationUpdateRequest setId(Long id) {
        this.id = id;
        return this;
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public ReservationUpdateRequest setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
        return this;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public ReservationUpdateRequest setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
        return this;
    }
}
