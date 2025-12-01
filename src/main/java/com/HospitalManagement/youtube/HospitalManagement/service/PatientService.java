package com.HospitalManagement.youtube.HospitalManagement.service;

import com.HospitalManagement.youtube.HospitalManagement.Entity.Patient;
import com.HospitalManagement.youtube.HospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id){
        Patient p1 = patientRepository.findById(id).orElseThrow();

        Patient p2 = patientRepository.findById(id).orElseThrow();

        System.out.println(p1==p2);

        p1.setName("yoyo");


        return p1;
    }



}
