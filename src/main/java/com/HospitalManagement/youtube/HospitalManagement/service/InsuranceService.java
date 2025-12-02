package com.HospitalManagement.youtube.HospitalManagement.service;

import com.HospitalManagement.youtube.HospitalManagement.Entity.Insurance;
import com.HospitalManagement.youtube.HospitalManagement.Entity.Patient;
import com.HospitalManagement.youtube.HospitalManagement.repository.InsuranceRepository;
import com.HospitalManagement.youtube.HospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;
    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: "+patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient);

        return patient;
    }

    @Transactional
    public Patient disaccociateInsurenceFromPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new EntityNotFoundException("patient not found with id: "+patientId));

        patient.setInsurance(null);
        return patient;
    }


}
