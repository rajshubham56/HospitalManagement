package com.HospitalManagement.youtube.HospitalManagement;

import com.HospitalManagement.youtube.HospitalManagement.Entity.Appointment;
import com.HospitalManagement.youtube.HospitalManagement.Entity.Insurance;
import com.HospitalManagement.youtube.HospitalManagement.Entity.Patient;
import com.HospitalManagement.youtube.HospitalManagement.service.AppointmentService;
import com.HospitalManagement.youtube.HospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_123")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);

        var newPatient = insuranceService.disaccociateInsurenceFromPatient(patient.getId());

        System.out.println(newPatient);
    }

    @Test
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,1,14,52))
                .reason("fever")
                .build();

        var newAppointment = appointmentService.createNewAppointment(appointment,1L,2L);

        System.out.println(newAppointment);

        var updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(),3L);
        System.out.println(updatedAppointment);
    }

}
