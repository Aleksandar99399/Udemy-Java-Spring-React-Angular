package com.aleksandar.clinicals.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastName;
    private String firstName;
    private int age;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "patient")
    private List<ClinicalData> clinicalData;

    public int getId() {
        return id;
    }

    public Patient setId(int id) {
        this.id = id;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Patient setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Patient setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Patient setAge(int age) {
        this.age = age;
        return this;
    }

    public List<ClinicalData> getClinicalData() {
        return clinicalData;
    }

    public Patient setClinicalData(List<ClinicalData> clinicalData) {
        this.clinicalData = clinicalData;
        return this;
    }
}
