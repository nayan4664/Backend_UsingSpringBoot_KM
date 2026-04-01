package com.kavyamargin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavyamargin.backend.model.RiskRecord;

public interface RiskRepository extends JpaRepository<RiskRecord, String> {
}
