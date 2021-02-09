package com.aleksandar.clinicals.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "clinicaldata")
public class ClinicalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String componentName;
    private String componentValue;
    private Timestamp measuredDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id",nullable = false)
    @JsonIgnore
    private Patient patient;

    public int getId() {
        return id;
    }

    public ClinicalData setId(int id) {
        this.id = id;
        return this;
    }

    public String getComponentName() {
        return componentName;
    }

    public ClinicalData setComponentName(String componentName) {
        this.componentName = componentName;
        return this;
    }

    public String getComponentValue() {
        return componentValue;
    }

    public ClinicalData setComponentValue(String componentValue) {
        this.componentValue = componentValue;
        return this;
    }

    public Timestamp getMeasuredDateTime() {
        return measuredDateTime;
    }

    public ClinicalData setMeasuredDateTime(Timestamp measuredDateTime) {
        this.measuredDateTime = measuredDateTime;
        return this;
    }

    public Patient getPatient() {
        return patient;
    }

    public ClinicalData setPatient(Patient patient) {
        this.patient = patient;
        return this;
    }
}
