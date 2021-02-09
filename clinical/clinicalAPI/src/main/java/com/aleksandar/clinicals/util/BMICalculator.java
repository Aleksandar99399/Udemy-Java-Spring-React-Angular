package com.aleksandar.clinicals.util;

import com.aleksandar.clinicals.model.ClinicalData;

import java.util.List;

public class BMICalculator {
    public static void calculateBMI(List<ClinicalData> clinicalData, ClinicalData entry) {
        if (entry.getComponentName().equals("hw")) {

            String[] heightAndWeight = entry.getComponentValue().split("/");
            if (heightAndWeight != null && heightAndWeight.length > 1) {

                float heightInMeters = Float.parseFloat(heightAndWeight[0]) * 0.4536F;
                float bmi = Float.parseFloat(heightAndWeight[1]) / (heightInMeters * heightInMeters);

                ClinicalData bmiData = new ClinicalData();
                bmiData.setComponentName("bmi");
                bmiData.setComponentValue(Float.toString(bmi));

                clinicalData.add(bmiData);
            }
        }
    }
}
