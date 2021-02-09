package com.aleksandar.clinicals.controllers;

import com.aleksandar.clinicals.dto.ClinicalDataRequest;
import com.aleksandar.clinicals.model.ClinicalData;
import com.aleksandar.clinicals.model.Patient;
import com.aleksandar.clinicals.repositories.ClinicalDataRepository;
import com.aleksandar.clinicals.repositories.PatientRepository;
import com.aleksandar.clinicals.util.BMICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClinicalDataController {

    private ClinicalDataRepository clinicalDataRepository;
    private PatientRepository patientRepository;

    @Autowired
    public ClinicalDataController(ClinicalDataRepository clinicalDataRepository, PatientRepository patientRepository) {
        this.clinicalDataRepository = clinicalDataRepository;
        this.patientRepository = patientRepository;
    }

    @RequestMapping(value = "/clinicals",method = RequestMethod.POST)
    public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request){

        Patient patient = patientRepository.findById(request.getPatientId()).get();
        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setComponentName(request.getComponentName());
        clinicalData.setComponentValue(request.getComponentValue());
        clinicalData.setPatient(patient);

        return clinicalDataRepository.save(clinicalData);
    }

    @RequestMapping(value = "/clinicals/{patientId}/{componentName}",method = RequestMethod.GET)
    public List<ClinicalData> getClinicalData(@PathVariable("patientId") int patientId,
                                              @PathVariable("componentName") String componentName){
        if(componentName.equals("bmi")){
            componentName = "hw";
        }

        List<ClinicalData> clinicalData =
                clinicalDataRepository.findByPatientIdAndComponentNameOrderByMeasuredDateTime(patientId, componentName);
        List<ClinicalData> duplicateClinicalData = new ArrayList<>(clinicalData);

        for (ClinicalData entry : duplicateClinicalData) {
            BMICalculator.calculateBMI(clinicalData,entry);
        }

        return clinicalData;

    }
}
