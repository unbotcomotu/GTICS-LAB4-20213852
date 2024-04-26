package com.example.gticslab420213852.Repository;

import com.example.gticslab420213852.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}