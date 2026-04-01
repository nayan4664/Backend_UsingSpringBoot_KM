package com.kavyamargin.backend.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class InvoiceItem {

    private String description;
    private Double hours;
    private Double rate;
    private Double amount;

    public InvoiceItem() {
    }

    public InvoiceItem(String description, Double hours, Double rate, Double amount) {
        this.description = description;
        this.hours = hours;
        this.rate = rate;
        this.amount = amount;
    }

    public String description() {
        return description;
    }

    public Double hours() {
        return hours;
    }

    public Double rate() {
        return rate;
    }

    public Double amount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
