package com.kavyamargin.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "contracts")
public class ContractRecord extends BaseEntity {

    private String name;
    private String client;
    private String type;
    private String status;

    @Column(name = "upload_date")
    private String uploadDate;

    @Column(name = "renewal_date")
    private String renewalDate;

    @Column(name = "compliance_score")
    private Integer complianceScore;

    private String owner;

    @Column(length = 4000)
    private String summary;

    public ContractRecord() {
    }

    public ContractRecord(String id, String name, String client, String type, String status, String uploadDate, String renewalDate,
            Integer complianceScore, String owner, String summary) {
        super(id);
        this.name = name;
        this.client = client;
        this.type = type;
        this.status = status;
        this.uploadDate = uploadDate;
        this.renewalDate = renewalDate;
        this.complianceScore = complianceScore;
        this.owner = owner;
        this.summary = summary;
    }

    public String name() {
        return name;
    }

    public String client() {
        return client;
    }

    public String type() {
        return type;
    }

    public String status() {
        return status;
    }

    public String uploadDate() {
        return uploadDate;
    }

    public String renewalDate() {
        return renewalDate;
    }

    public Integer complianceScore() {
        return complianceScore;
    }

    public String owner() {
        return owner;
    }

    public String summary() {
        return summary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(String renewalDate) {
        this.renewalDate = renewalDate;
    }

    public Integer getComplianceScore() {
        return complianceScore;
    }

    public void setComplianceScore(Integer complianceScore) {
        this.complianceScore = complianceScore;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
