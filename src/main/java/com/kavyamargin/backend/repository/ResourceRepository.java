package com.kavyamargin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavyamargin.backend.model.ResourceRecord;

public interface ResourceRepository extends JpaRepository<ResourceRecord, String> {
}
