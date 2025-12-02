package com.HospitalManagement.youtube.HospitalManagement.repository;

import com.HospitalManagement.youtube.HospitalManagement.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}