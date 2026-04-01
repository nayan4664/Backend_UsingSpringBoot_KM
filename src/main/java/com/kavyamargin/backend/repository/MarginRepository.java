package com.kavyamargin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavyamargin.backend.model.MarginRecord;

public interface MarginRepository extends JpaRepository<MarginRecord, String> {
}
