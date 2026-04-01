package com.kavyamargin.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "margins")
public class MarginRecord extends BaseEntity {

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "client_name")
    private String clientName;

    private Double revenue;
    private Double cost;

    @Column(name = "gross_margin")
    private Double grossMargin;

    @Column(name = "net_margin")
    private Double netMargin;

    @Column(name = "target_margin")
    private Double targetMargin;

    private String month;

    public MarginRecord() {
    }

    public MarginRecord(String id, String projectName, String clientName, Double revenue, Double cost, Double grossMargin,
            Double netMargin, Double targetMargin, String month) {
        super(id);
        this.projectName = projectName;
        this.clientName = clientName;
        this.revenue = revenue;
        this.cost = cost;
        this.grossMargin = grossMargin;
        this.netMargin = netMargin;
        this.targetMargin = targetMargin;
        this.month = month;
    }

    public String projectName() {
        return projectName;
    }

    public String clientName() {
        return clientName;
    }

    public Double revenue() {
        return revenue;
    }

    public Double cost() {
        return cost;
    }

    public Double grossMargin() {
        return grossMargin;
    }

    public Double netMargin() {
        return netMargin;
    }

    public Double targetMargin() {
        return targetMargin;
    }

    public String month() {
        return month;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getGrossMargin() {
        return grossMargin;
    }

    public void setGrossMargin(Double grossMargin) {
        this.grossMargin = grossMargin;
    }

    public Double getNetMargin() {
        return netMargin;
    }

    public void setNetMargin(Double netMargin) {
        this.netMargin = netMargin;
    }

    public Double getTargetMargin() {
        return targetMargin;
    }

    public void setTargetMargin(Double targetMargin) {
        this.targetMargin = targetMargin;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
