package com.kavyamargin.backend.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kavyamargin.backend.model.BenchResource;
import com.kavyamargin.backend.model.BillingModelRecord;
import com.kavyamargin.backend.model.CompanyProfile;
import com.kavyamargin.backend.model.ContractRecord;
import com.kavyamargin.backend.model.DepartmentRecord;
import com.kavyamargin.backend.model.Employee;
import com.kavyamargin.backend.model.ForecastReportRecord;
import com.kavyamargin.backend.model.Invoice;
import com.kavyamargin.backend.model.InvoiceItem;
import com.kavyamargin.backend.model.MarginRecord;
import com.kavyamargin.backend.model.ResourceRecord;
import com.kavyamargin.backend.model.RevenueForecast;
import com.kavyamargin.backend.model.RiskRecord;
import com.kavyamargin.backend.repository.BenchRepository;
import com.kavyamargin.backend.repository.BillingModelRepository;
import com.kavyamargin.backend.repository.CompanyProfileRepository;
import com.kavyamargin.backend.repository.ContractRepository;
import com.kavyamargin.backend.repository.DepartmentRepository;
import com.kavyamargin.backend.repository.EmployeeRepository;
import com.kavyamargin.backend.repository.ForecastReportRepository;
import com.kavyamargin.backend.repository.InvoiceRepository;
import com.kavyamargin.backend.repository.MarginRepository;
import com.kavyamargin.backend.repository.ResourceRepository;
import com.kavyamargin.backend.repository.RevenueForecastRepository;
import com.kavyamargin.backend.repository.RiskRepository;

@Component
public class DataSeeder implements CommandLineRunner {

    private final boolean seedEnabled;
    private final EmployeeRepository employeeRepository;
    private final BenchRepository benchRepository;
    private final ResourceRepository resourceRepository;
    private final InvoiceRepository invoiceRepository;
    private final ContractRepository contractRepository;
    private final RiskRepository riskRepository;
    private final MarginRepository marginRepository;
    private final BillingModelRepository billingModelRepository;
    private final DepartmentRepository departmentRepository;
    private final CompanyProfileRepository companyProfileRepository;
    private final RevenueForecastRepository revenueForecastRepository;
    private final ForecastReportRepository forecastReportRepository;

    public DataSeeder(
        @Value("${app.seed.enabled:true}") boolean seedEnabled,
        EmployeeRepository employeeRepository,
        BenchRepository benchRepository,
        ResourceRepository resourceRepository,
        InvoiceRepository invoiceRepository,
        ContractRepository contractRepository,
        RiskRepository riskRepository,
        MarginRepository marginRepository,
        BillingModelRepository billingModelRepository,
        DepartmentRepository departmentRepository,
        CompanyProfileRepository companyProfileRepository,
        RevenueForecastRepository revenueForecastRepository,
        ForecastReportRepository forecastReportRepository
    ) {
        this.seedEnabled = seedEnabled;
        this.employeeRepository = employeeRepository;
        this.benchRepository = benchRepository;
        this.resourceRepository = resourceRepository;
        this.invoiceRepository = invoiceRepository;
        this.contractRepository = contractRepository;
        this.riskRepository = riskRepository;
        this.marginRepository = marginRepository;
        this.billingModelRepository = billingModelRepository;
        this.departmentRepository = departmentRepository;
        this.companyProfileRepository = companyProfileRepository;
        this.revenueForecastRepository = revenueForecastRepository;
        this.forecastReportRepository = forecastReportRepository;
    }

    @Override
    public void run(String... args) {
        if (!seedEnabled) {
            return;
        }
        seedEmployees();
        seedBench();
        seedResources();
        seedInvoices();
        seedContracts();
        seedRisks();
        seedMargins();
        seedBillingModels();
        seedDepartments();
        seedCompany();
        seedRevenueForecasts();
        seedForecastReports();
    }

    private void seedEmployees() {
        if (employeeRepository.count() > 0) {
            return;
        }
        employeeRepository.saveAll(List.of(
            new Employee(null, "Anita Sharma", "Backend Developer", "Engineering", 1200000.0, 100000.0, "anita@kavyainfoweb.com", LocalDate.of(2024, 4, 15), 10.0, "Offshore"),
            new Employee(null, "Vikas Mehta", "QA Engineer", "Engineering", 840000.0, 70000.0, "vikas@kavyainfoweb.com", LocalDate.of(2023, 9, 10), 8.0, "Offshore"),
            new Employee(null, "Rhea Kapoor", "UI Designer", "Design", 960000.0, 80000.0, "rhea@kavyainfoweb.com", LocalDate.of(2025, 1, 20), 12.0, "Onsite")
        ));
    }

    private void seedBench() {
        if (benchRepository.count() > 0) {
            return;
        }
        benchRepository.saveAll(List.of(
            new BenchResource(null, "Rahul Reddy", "Developer", 4, 150000.0, "Engineering", "Available"),
            new BenchResource(null, "Sneha Jain", "QA Lead", 2, 110000.0, "Quality", "Interviewing")
        ));
    }

    private void seedResources() {
        if (resourceRepository.count() > 0) {
            return;
        }
        resourceRepository.saveAll(List.of(
            new ResourceRecord(null, "Amit Verma", "Backend Developer", "Java", "Spring Boot", "Advanced", 5, "Project Alpha", "Immediate", 100, 0, "Engineering"),
            new ResourceRecord(null, "Kriti Rao", "Frontend Developer", "React", "Tailwind", "Advanced", 4, "Project Orion", "2026-04-20", 40, 60, "Engineering"),
            new ResourceRecord(null, "Nikhil Jain", "Data Analyst", "Power BI", "SQL", "Intermediate", 3, "None", "2026-05-15", 80, 20, "Product")
        ));
    }

    private void seedInvoices() {
        if (invoiceRepository.count() > 0) {
            return;
        }
        invoiceRepository.saveAll(List.of(
            new Invoice(null, "INV-2026-101", "Acme Corp", "Project Alpha", LocalDate.now().minusDays(12), LocalDate.now().plusDays(3),
                List.of(new InvoiceItem("Development Services", 160.0, 45.0, 7200.0)), 18.0, "Payment due within 15 days.", "Pending"),
            new Invoice(null, "INV-2026-102", "BrightEdge", "Migration Program", LocalDate.now().minusDays(40), LocalDate.now().minusDays(10),
                List.of(new InvoiceItem("Cloud Migration", 120.0, 55.0, 6600.0)), 18.0, "Late fee applicable after due date.", "Overdue"),
            new Invoice(null, "INV-2026-103", "Nova Retail", "Support Retainer", LocalDate.now().minusDays(20), LocalDate.now().minusDays(2),
                List.of(new InvoiceItem("Support Retainer", 80.0, 35.0, 2800.0)), 18.0, "Paid in full.", "Paid")
        ));
    }

    private void seedContracts() {
        if (contractRepository.count() > 0) {
            return;
        }
        contractRepository.saveAll(List.of(
            new ContractRecord(null, "Acme MSA", "Acme Corp", "MSA", "Active", "2026-02-10", "2027-02-10", 94, "Legal Team", "Long-term services agreement with annual renewal."),
            new ContractRecord(null, "BrightEdge SOW", "BrightEdge", "SOW", "Review", "2026-03-05", "2026-09-05", 88, "PMO", "Deployment scope for analytics modernization.")
        ));
    }

    private void seedRisks() {
        if (riskRepository.count() > 0) {
            return;
        }
        riskRepository.saveAll(List.of(
            new RiskRecord(null, "Late client approvals", "Delivery", "High", "Milestone delay", "Escalate approvals weekly", "Open"),
            new RiskRecord(null, "Bench cost spike", "Finance", "Medium", "Margin pressure", "Reallocate idle resources", "Monitoring")
        ));
    }

    private void seedMargins() {
        if (marginRepository.count() > 0) {
            return;
        }
        marginRepository.saveAll(List.of(
            new MarginRecord(null, "Project Alpha", "Acme Corp", 2400000.0, 1560000.0, 35.0, 30.0, 28.0, "Jan"),
            new MarginRecord(null, "Project Orion", "BrightEdge", 2600000.0, 1716000.0, 34.0, 28.0, 27.0, "Feb"),
            new MarginRecord(null, "Migration Program", "Nova Retail", 2900000.0, 1885000.0, 35.0, 31.0, 29.0, "Mar"),
            new MarginRecord(null, "Support Retainer", "Acme Corp", 3000000.0, 1950000.0, 35.0, 33.0, 30.0, "Apr"),
            new MarginRecord(null, "Data Platform", "BrightEdge", 3150000.0, 2047500.0, 35.0, 34.0, 31.0, "May"),
            new MarginRecord(null, "Project Atlas", "Nova Retail", 3400000.0, 2142000.0, 37.0, 35.0, 32.0, "Jun")
        ));
    }

    private void seedBillingModels() {
        if (billingModelRepository.count() > 0) {
            return;
        }
        billingModelRepository.saveAll(List.of(
            new BillingModelRecord(null, "Time and Material", "Flexible model billed on actual effort.", 28.0, "Variable"),
            new BillingModelRecord(null, "Fixed Price", "Milestone-based billing for scoped work.", 32.0, "Fixed")
        ));
    }

    private void seedDepartments() {
        if (departmentRepository.count() > 0) {
            return;
        }
        departmentRepository.saveAll(List.of(
            new DepartmentRecord(null, "Engineering", "Sushil Kumar", 42, "INR 75,00,000"),
            new DepartmentRecord(null, "Design", "Priti Deshmukh", 12, "INR 18,00,000"),
            new DepartmentRecord(null, "HR", "Raj Malhotra", 6, "INR 9,00,000")
        ));
    }

    private void seedCompany() {
        if (companyProfileRepository.count() > 0) {
            return;
        }
        companyProfileRepository.save(new CompanyProfile(
            "default",
            "Kavya Margin",
            "KM12345IN",
            "GSTIN123456",
            "IT Services",
            "https://kavyainfoweb.com",
            "contact@kavyainfoweb.com",
            "+91 9876543210",
            "Jaipur, Rajasthan, India",
            "INR",
            "April"
        ));
    }

    private void seedRevenueForecasts() {
        if (revenueForecastRepository.count() > 0) {
            return;
        }
        revenueForecastRepository.saveAll(List.of(
            new RevenueForecast(null, "Jan", 2026, 2400000.0, 1900000.0, 2200000.0),
            new RevenueForecast(null, "Feb", 2026, 2600000.0, 2050000.0, 2400000.0),
            new RevenueForecast(null, "Mar", 2026, 2850000.0, 2250000.0, 2600000.0),
            new RevenueForecast(null, "Apr", 2026, 3000000.0, 2400000.0, 2800000.0),
            new RevenueForecast(null, "May", 2026, 3200000.0, 2550000.0, 3000000.0),
            new RevenueForecast(null, "Jun", 2026, 3500000.0, 2800000.0, 3200000.0)
        ));
    }

    private void seedForecastReports() {
        if (forecastReportRepository.count() > 0) {
            return;
        }
        forecastReportRepository.saveAll(List.of(
            new ForecastReportRecord(null, "March Revenue Close", "Financial", "Finance Team", LocalDate.of(2026, 3, 31), "1.2 MB"),
            new ForecastReportRecord(null, "Q2 Pipeline Outlook", "Forecast", "Sales Ops", LocalDate.of(2026, 4, 2), "860 KB"),
            new ForecastReportRecord(null, "Margin Efficiency Summary", "Efficiency", "PMO", LocalDate.of(2026, 4, 5), "940 KB"),
            new ForecastReportRecord(null, "Growth Strategy Review", "Strategy", "Leadership", LocalDate.of(2026, 4, 8), "1.5 MB")
        ));
    }
}
