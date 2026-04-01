package com.kavyamargin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavyamargin.backend.model.ForecastReportRecord;

public interface ForecastReportRepository extends JpaRepository<ForecastReportRecord, String> {
}
