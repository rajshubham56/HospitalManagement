package com.HospitalManagement.youtube.HospitalManagement.service;

import com.HospitalManagement.youtube.HospitalManagement.Entity.Appointment;
import com.HospitalManagement.youtube.HospitalManagement.Entity.Doctor;
import com.HospitalManagement.youtube.HospitalManagement.Entity.Patient;
import com.HospitalManagement.youtube.HospitalManagement.repository.AppointmentRepository;
import com.HospitalManagement.youtube.HospitalManagement.repository.DoctorRepository;
import com.HospitalManagement.youtube.HospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    @Transactional
    public Appointment createNewAppointment(Appointment appointment,Long doctorId, Long patientId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("Appointment should not have id");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId,Long doctorId){
        Appointment appointment =  appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);

        doctor.getAppointments().add(appointment);
        return appointment;
    }
}
