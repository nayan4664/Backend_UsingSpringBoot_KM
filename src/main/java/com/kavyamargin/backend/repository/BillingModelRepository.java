package com.kavyamargin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavyamargin.backend.model.BillingModelRecord;

public interface BillingModelRepository extends JpaRepository<BillingModelRecord, String> {
}
