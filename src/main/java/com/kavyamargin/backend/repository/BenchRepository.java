package com.kavyamargin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavyamargin.backend.model.BenchResource;

public interface BenchRepository extends JpaRepository<BenchResource, String> {
}
