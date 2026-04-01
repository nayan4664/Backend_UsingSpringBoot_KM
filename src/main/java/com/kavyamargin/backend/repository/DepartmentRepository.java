package com.kavyamargin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavyamargin.backend.model.DepartmentRecord;

public interface DepartmentRepository extends JpaRepository<DepartmentRecord, String> {
}
