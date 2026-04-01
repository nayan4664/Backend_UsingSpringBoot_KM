package com.kavyamargin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavyamargin.backend.model.ContractRecord;

public interface ContractRepository extends JpaRepository<ContractRecord, String> {
}
