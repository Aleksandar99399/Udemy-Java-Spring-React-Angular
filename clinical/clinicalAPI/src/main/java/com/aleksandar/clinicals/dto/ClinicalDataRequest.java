package com.aleksandar.clinicals.dto;

public class ClinicalDataRequest {

    private String componentName;
    private String componentValue;
    private int patientId;

    public String getComponentName() {
        return componentName;
    }

    public ClinicalDataRequest setComponentName(String componentName) {
        this.componentName = componentName;
        return this;
    }

    public String getComponentValue() {
        return componentValue;
    }

    public ClinicalDataRequest setComponentValue(String componentValue) {
        this.componentValue = componentValue;
        return this;
    }

    public int getPatientId() {
        return patientId;
    }

    public ClinicalDataRequest setPatientId(int patientId) {
        this.patientId = patientId;
        return this;
    }
}
