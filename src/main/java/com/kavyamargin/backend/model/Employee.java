package com.kavyamargin.backend.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {

    private String name;
    private String role;
    private String department;

    @JsonProperty("CTC")
    @Column(name = "ctc")
    private Double ctc;

    @Column(name = "monthly_cost")
    private Double monthlyCost;

    private String email;

    @Column(name = "joining_date")
    private LocalDate joiningDate;

    @Column(name = "variable_pay")
    private Double variablePay;

    private String location;

    public Employee() {
    }

    public Employee(String id, String name, String role, String department, Double ctc, Double monthlyCost, String email,
            LocalDate joiningDate, Double variablePay, String location) {
        super(id);
        this.name = name;
        this.role = role;
        this.department = department;
        this.ctc = ctc;
        this.monthlyCost = monthlyCost;
        this.email = email;
        this.joiningDate = joiningDate;
        this.variablePay = variablePay;
        this.location = location;
    }

    public String name() {
        return name;
    }

    public String role() {
        return role;
    }

    public String department() {
        return department;
    }

    public Double CTC() {
        return ctc;
    }

    public Double monthlyCost() {
        return monthlyCost;
    }

    public String email() {
        return email;
    }

    public LocalDate joiningDate() {
        return joiningDate;
    }

    public Double variablePay() {
        return variablePay;
    }

    public String location() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getCTC() {
        return ctc;
    }

    public void setCTC(Double ctc) {
        this.ctc = ctc;
    }

    public Double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(Double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Double getVariablePay() {
        return variablePay;
    }

    public void setVariablePay(Double variablePay) {
        this.variablePay = variablePay;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
