package com.kavyamargin.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "billing_models")
public class BillingModelRecord extends BaseEntity {

    @Column(name = "model_name")
    private String modelName;

    @Column(length = 2000)
    private String description;

    private Double rate;
    private String type;

    public BillingModelRecord() {
    }

    public BillingModelRecord(String id, String modelName, String description, Double rate, String type) {
        super(id);
        this.modelName = modelName;
        this.description = description;
        this.rate = rate;
        this.type = type;
    }

    public String modelName() {
        return modelName;
    }

    public String description() {
        return description;
    }

    public Double rate() {
        return rate;
    }

    public String type() {
        return type;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
