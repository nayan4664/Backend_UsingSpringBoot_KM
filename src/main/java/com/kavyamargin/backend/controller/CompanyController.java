package com.kavyamargin.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kavyamargin.backend.model.CompanyProfile;
import com.kavyamargin.backend.repository.CompanyProfileRepository;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyProfileRepository companyProfileRepository;

    public CompanyController(CompanyProfileRepository companyProfileRepository) {
        this.companyProfileRepository = companyProfileRepository;
    }

    @GetMapping
    public CompanyProfile getCompany() {
        return companyProfileRepository.findById("default")
            .orElse(new CompanyProfile("default", "", "", "", "", "", "", "", "", "INR", "April"));
    }

    @PutMapping
    public CompanyProfile updateCompany(@RequestBody CompanyProfile profile) {
        return companyProfileRepository.save(new CompanyProfile(
            "default",
            profile.companyName(),
            profile.registrationNumber(),
            profile.taxId(),
            profile.industry(),
            profile.website(),
            profile.email(),
            profile.phone(),
            profile.address(),
            profile.currency() == null ? "INR" : profile.currency(),
            profile.fiscalYearStart() == null ? "April" : profile.fiscalYearStart()
        ));
    }
}
