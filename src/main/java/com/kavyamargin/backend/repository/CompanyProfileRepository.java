package com.kavyamargin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavyamargin.backend.model.CompanyProfile;

public interface CompanyProfileRepository extends JpaRepository<CompanyProfile, String> {
}
