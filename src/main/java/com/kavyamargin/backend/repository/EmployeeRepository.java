package com.kavyamargin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavyamargin.backend.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
