package com.kavyamargin.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "risks")
public class RiskRecord extends BaseEntity {

    private String title;
    private String category;
    private String severity;

    @Column(length = 2000)
    private String impact;

    @Column(length = 2000)
    private String mitigation;

    private String status;

    public RiskRecord() {
    }

    public RiskRecord(String id, String title, String category, String severity, String impact, String mitigation, String status) {
        super(id);
        this.title = title;
        this.category = category;
        this.severity = severity;
        this.impact = impact;
        this.mitigation = mitigation;
        this.status = status;
    }

    public String title() {
        return title;
    }

    public String category() {
        return category;
    }

    public String severity() {
        return severity;
    }

    public String impact() {
        return impact;
    }

    public String mitigation() {
        return mitigation;
    }

    public String status() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getMitigation() {
        return mitigation;
    }

    public void setMitigation(String mitigation) {
        this.mitigation = mitigation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
