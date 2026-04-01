package com.kavyamargin.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "bench_resources")
public class BenchResource extends BaseEntity {

    private String name;
    private String role;

    @JsonProperty("bench_duration_weeks")
    @Column(name = "bench_duration_weeks")
    private Integer benchDurationWeeks;

    @JsonProperty("cost_impact")
    @Column(name = "cost_impact")
    private Double costImpact;

    @JsonProperty("primary_skill")
    @Column(name = "primary_skill")
    private String primarySkill;

    private String status;

    public BenchResource() {
    }

    public BenchResource(String id, String name, String role, Integer benchDurationWeeks, Double costImpact, String primarySkill, String status) {
        super(id);
        this.name = name;
        this.role = role;
        this.benchDurationWeeks = benchDurationWeeks;
        this.costImpact = costImpact;
        this.primarySkill = primarySkill;
        this.status = status;
    }

    public String name() {
        return name;
    }

    public String role() {
        return role;
    }

    public Integer bench_duration_weeks() {
        return benchDurationWeeks;
    }

    public Double cost_impact() {
        return costImpact;
    }

    public String primary_skill() {
        return primarySkill;
    }

    public String status() {
        return status;
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

    public Integer getBenchDurationWeeks() {
        return benchDurationWeeks;
    }

    public void setBenchDurationWeeks(Integer benchDurationWeeks) {
        this.benchDurationWeeks = benchDurationWeeks;
    }

    public Double getCostImpact() {
        return costImpact;
    }

    public void setCostImpact(Double costImpact) {
        this.costImpact = costImpact;
    }

    public String getPrimarySkill() {
        return primarySkill;
    }

    public void setPrimarySkill(String primarySkill) {
        this.primarySkill = primarySkill;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
