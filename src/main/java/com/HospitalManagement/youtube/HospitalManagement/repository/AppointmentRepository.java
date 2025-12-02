package com.HospitalManagement.youtube.HospitalManagement.repository;

import com.HospitalManagement.youtube.HospitalManagement.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}