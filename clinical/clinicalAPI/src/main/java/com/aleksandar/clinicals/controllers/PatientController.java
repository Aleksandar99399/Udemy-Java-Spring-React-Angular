package com.aleksandar.clinicals.controllers;

import com.aleksandar.clinicals.model.ClinicalData;
import com.aleksandar.clinicals.model.Patient;
import com.aleksandar.clinicals.repositories.PatientRepository;
import com.aleksandar.clinicals.util.BMICalculator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientController {


    private PatientRepository repository;
    Map<String, String> filters = new HashMap<>();

    @Autowired
    public PatientController(PatientRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public List<Patient> getPatients() {
        return repository.findAll();
    }

    @RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
    public Patient getPatient(@PathVariable("id") int id) {

        return repository.findById(id).get();
    }

    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    public Patient savePatient(@RequestBody Patient patient) {
        return repository.save(patient);
    }

    @RequestMapping(value = "/patients/analyze/{id}", method = RequestMethod.GET)
    public Patient analyze(@PathVariable("id") int id) {
        Patient patient = repository.findById(id).get();

        List<ClinicalData> clinicalData = patient.getClinicalData();
        List<ClinicalData> duplicateClinicalData = new ArrayList<>(clinicalData);

        for (ClinicalData entry : duplicateClinicalData) {
            if (filters.containsKey(entry.getComponentName())) {
                clinicalData.remove(entry);
                continue;
            }else {
                filters.put(entry.getComponentName(),null);
            }

             BMICalculator.calculateBMI(clinicalData, entry);

        }
        filters.clear();
        return patient;
    }

}
