package com.kavyamargin.backend.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kavyamargin.backend.model.ForecastReportRecord;
import com.kavyamargin.backend.model.RevenueForecast;
import com.kavyamargin.backend.repository.ForecastReportRepository;
import com.kavyamargin.backend.repository.MarginRepository;
import com.kavyamargin.backend.repository.RevenueForecastRepository;

@Service
public class ForecastService {

    private final RevenueForecastRepository revenueForecastRepository;
    private final MarginRepository marginRepository;
    private final ForecastReportRepository forecastReportRepository;

    public ForecastService(
        RevenueForecastRepository revenueForecastRepository,
        MarginRepository marginRepository,
        ForecastReportRepository forecastReportRepository
    ) {
        this.revenueForecastRepository = revenueForecastRepository;
        this.marginRepository = marginRepository;
        this.forecastReportRepository = forecastReportRepository;
    }

    public List<RevenueForecast> getRevenue() {
        return revenueForecastRepository.findAll().stream()
            .sorted(Comparator.comparing(RevenueForecast::year).thenComparing(item -> monthOrder(item.month())))
            .toList();
    }

    public List<Map<String, Object>> getMarginTrends() {
        return marginRepository.findAll().stream()
            .sorted(Comparator.comparing(item -> monthOrder(item.month())))
            .map(item -> Map.<String, Object>of(
                "month", item.month(),
                "gross", val(item.grossMargin()),
                "net", val(item.netMargin()),
                "target", val(item.targetMargin())
            ))
            .toList();
    }

    public List<ForecastReportRecord> getReports() {
        return forecastReportRepository.findAll().stream()
            .sorted(Comparator.comparing(ForecastReportRecord::date).reversed())
            .toList();
    }

    public Map<String, Object> getProjections() {
        double totalRevenue = revenueForecastRepository.findAll().stream().mapToDouble(item -> val(item.confirmed())).sum();
        double totalWeighted = revenueForecastRepository.findAll().stream().mapToDouble(item -> val(item.weighted())).sum();
        double totalCost = marginRepository.findAll().stream().mapToDouble(item -> val(item.cost())).sum();
        double avgNetMargin = marginRepository.findAll().stream().mapToDouble(item -> val(item.netMargin())).average().orElse(0);

        return Map.of(
            "projections", getRevenue(),
            "summary", Map.of(
                "totalEstRevenue", totalRevenue,
                "totalEstCost", totalCost,
                "projectedMargin", Math.round(avgNetMargin),
                "forecastAccuracy", 93
            ),
            "recommendations", List.of(
                Map.of("impact", "High", "title", "Accelerate high-margin accounts", "desc", "Prioritize renewals and upsell on accounts already above target margin."),
                Map.of("impact", "Medium", "title", "Reduce bench pressure", "desc", "Move partially allocated resources into open forecast demand within 30 days."),
                Map.of("impact", "Low", "title", "Tighten billing cadence", "desc", "Shorter invoice cycles can improve cash flow against weighted pipeline.")
            ),
            "weightedPipeline", totalWeighted
        );
    }

    private double val(Double value) {
        return value == null ? 0 : value;
    }

    private int monthOrder(String month) {
        List<String> months = List.of("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        int index = months.indexOf(month);
        return index < 0 ? Integer.MAX_VALUE : index;
    }
}
