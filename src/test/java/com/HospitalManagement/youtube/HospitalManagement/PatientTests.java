package com.HospitalManagement.youtube.HospitalManagement;

import com.HospitalManagement.youtube.HospitalManagement.DTO.BloodGroupCountResponseEntity;
import com.HospitalManagement.youtube.HospitalManagement.Entity.Patient;
import com.HospitalManagement.youtube.HospitalManagement.Entity.type.BloodGroupType;
import com.HospitalManagement.youtube.HospitalManagement.repository.PatientRepository;
import com.HospitalManagement.youtube.HospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);

        Patient p1 = new Patient();
        patientRepository.save(p1);
    }

    @Test
    public void testTransactionMethod() {
//        Patient patient = patientService.getPatientById(1L);


//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(1988, 03, 15), "diya.patel@example.com");

//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1993, 3,15));

        Page<Patient> patientList = patientRepository.findAllPatients(PageRequest.of(0, 2));

        for (Patient patient : patientList) {
            System.out.println(patient);
        }
//
//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(Object[] objects: bloodGroupList){
//            System.out.println(objects[0] +" "+objects[1]);
//        }

//        int rowUpdated = patientRepository.updateNameWithId("Aarav sharma", 1L);
//
//        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(BloodGroupCountResponseEntity bloodGroupCountResponse: bloodGroupList){
//            System.out.println(bloodGroupCountResponse);
//        }
    }
}
