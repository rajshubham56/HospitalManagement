package com.HospitalManagement.youtube.HospitalManagement.repository;

import com.HospitalManagement.youtube.HospitalManagement.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}