package com.kavyamargin.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kavyamargin.backend.model.ForecastReportRecord;
import com.kavyamargin.backend.model.RevenueForecast;
import com.kavyamargin.backend.service.ForecastService;

@RestController
@RequestMapping("/api/forecast")
public class ForecastController {

    private final ForecastService forecastService;

    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping("/projections")
    public Map<String, Object> getProjections() {
        return forecastService.getProjections();
    }

    @GetMapping("/revenue")
    public List<RevenueForecast> getRevenue() {
        return forecastService.getRevenue();
    }

    @GetMapping("/margin-trends")
    public List<?> getMarginTrends() {
        return forecastService.getMarginTrends();
    }

    @GetMapping("/reports")
    public List<ForecastReportRecord> getReports() {
        return forecastService.getReports();
    }
}
