package com.aleksandar.flightcheckin.dto;


import java.sql.Timestamp;
import java.time.LocalDate;

public class Flight{
    private Long id;
    private String flightNumber;
    private String operatingAirlines;
    private String departureCity;
    private String arrivalCity;
    private LocalDate dateOfDeparture;
    private Timestamp estimatedDepartureTime;


    public Long getId() {
        return id;
    }

    public Flight setId(Long id) {
        this.id = id;
        return this;
    }
    public String getFlightNumber() {
        return flightNumber;
    }

    public Flight setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
        return this;
    }

    public String getOperatingAirlines() {
        return operatingAirlines;
    }

    public Flight setOperatingAirlines(String operatingAirlines) {
        this.operatingAirlines = operatingAirlines;
        return this;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public Flight setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
        return this;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public Flight setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
        return this;
    }

    public LocalDate getDateOfDeparture() {
        return dateOfDeparture;
    }

    public Flight setDateOfDeparture(LocalDate dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
        return this;
    }

    public Timestamp getEstimatedDepartureTime() {
        return estimatedDepartureTime;
    }

    public Flight setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
        this.estimatedDepartureTime = estimatedDepartureTime;
        return this;
    }
}
