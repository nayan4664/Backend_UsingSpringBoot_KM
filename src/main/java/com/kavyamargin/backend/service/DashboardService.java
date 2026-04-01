package com.kavyamargin.backend.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kavyamargin.backend.model.Invoice;
import com.kavyamargin.backend.model.MarginRecord;
import com.kavyamargin.backend.model.ResourceRecord;
import com.kavyamargin.backend.repository.BenchRepository;
import com.kavyamargin.backend.repository.BillingModelRepository;
import com.kavyamargin.backend.repository.ContractRepository;
import com.kavyamargin.backend.repository.DepartmentRepository;
import com.kavyamargin.backend.repository.InvoiceRepository;
import com.kavyamargin.backend.repository.MarginRepository;
import com.kavyamargin.backend.repository.ResourceRepository;
import com.kavyamargin.backend.repository.RevenueForecastRepository;
import com.kavyamargin.backend.repository.RiskRepository;

@Service
public class DashboardService {

    private final InvoiceRepository invoiceRepository;
    private final MarginRepository marginRepository;
    private final ResourceRepository resourceRepository;
    private final BenchRepository benchRepository;
    private final ContractRepository contractRepository;
    private final RiskRepository riskRepository;
    private final BillingModelRepository billingModelRepository;
    private final DepartmentRepository departmentRepository;
    private final RevenueForecastRepository revenueForecastRepository;

    public DashboardService(
        InvoiceRepository invoiceRepository,
        MarginRepository marginRepository,
        ResourceRepository resourceRepository,
        BenchRepository benchRepository,
        ContractRepository contractRepository,
        RiskRepository riskRepository,
        BillingModelRepository billingModelRepository,
        DepartmentRepository departmentRepository,
        RevenueForecastRepository revenueForecastRepository
    ) {
        this.invoiceRepository = invoiceRepository;
        this.marginRepository = marginRepository;
        this.resourceRepository = resourceRepository;
        this.benchRepository = benchRepository;
        this.contractRepository = contractRepository;
        this.riskRepository = riskRepository;
        this.billingModelRepository = billingModelRepository;
        this.departmentRepository = departmentRepository;
        this.revenueForecastRepository = revenueForecastRepository;
    }

    public Map<String, Object> getStats() {
        List<MarginRecord> margins = marginRepository.findAll();
        List<ResourceRecord> resources = resourceRepository.findAll();
        List<Invoice> invoices = invoiceRepository.findAll();

        double totalRevenue = margins.stream().mapToDouble(record -> val(record.revenue())).sum();
        double totalCost = margins.stream().mapToDouble(record -> val(record.cost())).sum();
        double avgNetMargin = margins.isEmpty() ? 0 : margins.stream().mapToDouble(record -> val(record.netMargin())).average().orElse(0);
        long fullyAvailable = resources.stream().filter(resource -> num(resource.availabilityPercentage()) >= 80).count();
        long totalResources = resources.size();
        double utilization = totalResources == 0 ? 0 : ((double) (totalResources - fullyAvailable) / totalResources) * 100;
        long successfulProjects = margins.stream().filter(record -> val(record.netMargin()) >= val(record.targetMargin())).count();
        double successRate = margins.isEmpty() ? 0 : (successfulProjects * 100.0) / margins.size();
        double pendingDue = invoices.stream()
            .filter(invoice -> "Pending".equalsIgnoreCase(invoice.status()) || "Overdue".equalsIgnoreCase(invoice.status()))
            .mapToDouble(this::invoiceTotal)
            .sum();

        return Map.of(
            "kpis", Map.of(
                "totalMargin", formatMillions(totalRevenue - totalCost),
                "operationalCost", formatMillions(totalCost),
                "utilization", formatPercent(utilization),
                "successRate", formatPercent(successRate)
            ),
            "moduleInsights", List.of(
                module("Organization", "Active", departmentRepository.count() + " Depts", "text-blue-400"),
                module("Employee Cost", "On Track", formatMillions(totalCost), "text-indigo-400"),
                module("Billing", "Active", billingModelRepository.count() + " Configs", "text-violet-400"),
                module("Bench Management", "Optimization", benchRepository.count() + " Resources", "text-amber-400"),
                module("Contract Analyzer", contractRepository.count() + " Total", "92% Compliance", "text-emerald-400"),
                module("AI Prediction", "93% Acc", riskRepository.count() + " High Risks", "text-purple-400"),
                module("Invoicing", countInvoicesByStatus("Pending") + " Pending", formatMillions(pendingDue), "text-rose-400"),
                module("Margin Tracker", "Monitoring", formatPercent(avgNetMargin) + " Avg", "text-cyan-400"),
                module("Resource Allocation", "Active", (totalResources - fullyAvailable) + "/" + totalResources + " Assigned", "text-orange-400"),
                module("Revenue Forecast", revenueForecastRepository.count() + " Reports", formatMillions(totalRevenue), "text-green-400")
            )
        );
    }

    private Map<String, String> module(String label, String status, String value, String color) {
        return Map.of("label", label, "status", status, "value", value, "color", color);
    }

    private long countInvoicesByStatus(String status) {
        return invoiceRepository.findAll().stream().filter(invoice -> status.equalsIgnoreCase(invoice.status())).count();
    }

    private double invoiceTotal(Invoice invoice) {
        double subtotal = invoice.items() == null ? 0 : invoice.items().stream().mapToDouble(item -> val(item.amount())).sum();
        return subtotal + subtotal * (val(invoice.taxRate()) / 100);
    }

    private double val(Double value) {
        return value == null ? 0 : value;
    }

    private int num(Integer value) {
        return value == null ? 0 : value;
    }

    private String formatMillions(double amount) {
        return String.format("INR %.1fM", amount / 1_000_000d);
    }

    private String formatPercent(double value) {
        return String.format("%.0f%%", value);
    }
}
