package com.kavyamargin.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "company_profile")
public class CompanyProfile extends BaseEntity {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "tax_id")
    private String taxId;

    private String industry;
    private String website;
    private String email;
    private String phone;
    private String address;
    private String currency;

    @Column(name = "fiscal_year_start")
    private String fiscalYearStart;

    public CompanyProfile() {
    }

    public CompanyProfile(String id, String companyName, String registrationNumber, String taxId, String industry, String website,
            String email, String phone, String address, String currency, String fiscalYearStart) {
        super(id);
        this.companyName = companyName;
        this.registrationNumber = registrationNumber;
        this.taxId = taxId;
        this.industry = industry;
        this.website = website;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.currency = currency;
        this.fiscalYearStart = fiscalYearStart;
    }

    public String companyName() {
        return companyName;
    }

    public String registrationNumber() {
        return registrationNumber;
    }

    public String taxId() {
        return taxId;
    }

    public String industry() {
        return industry;
    }

    public String website() {
        return website;
    }

    public String email() {
        return email;
    }

    public String phone() {
        return phone;
    }

    public String address() {
        return address;
    }

    public String currency() {
        return currency;
    }

    public String fiscalYearStart() {
        return fiscalYearStart;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFiscalYearStart() {
        return fiscalYearStart;
    }

    public void setFiscalYearStart(String fiscalYearStart) {
        this.fiscalYearStart = fiscalYearStart;
    }
}
