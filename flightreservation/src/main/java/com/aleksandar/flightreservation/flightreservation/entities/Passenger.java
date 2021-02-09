package com.aleksandar.flightreservation.flightreservation.entities;

import javax.persistence.Entity;

@Entity
public class Passenger extends AbstractEntity {


    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;



    public String getFirstName() {
        return firstName;
    }

    public Passenger setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Passenger setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Passenger setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Passenger setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Passenger setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
