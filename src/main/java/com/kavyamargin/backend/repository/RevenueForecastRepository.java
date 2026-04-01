package com.kavyamargin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavyamargin.backend.model.RevenueForecast;

public interface RevenueForecastRepository extends JpaRepository<RevenueForecast, String> {
}
