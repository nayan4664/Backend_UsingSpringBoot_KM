package com.kavyamargin.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "revenue_forecasts")
public class RevenueForecast extends BaseEntity {

    private String month;

    @Column(name = "forecast_year")
    private Integer year;
    private Double confirmed;
    private Double weighted;
    private Double target;

    public RevenueForecast() {
    }

    public RevenueForecast(String id, String month, Integer year, Double confirmed, Double weighted, Double target) {
        super(id);
        this.month = month;
        this.year = year;
        this.confirmed = confirmed;
        this.weighted = weighted;
        this.target = target;
    }

    public String month() {
        return month;
    }

    public Integer year() {
        return year;
    }

    public Double confirmed() {
        return confirmed;
    }

    public Double weighted() {
        return weighted;
    }

    public Double target() {
        return target;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Double confirmed) {
        this.confirmed = confirmed;
    }

    public Double getWeighted() {
        return weighted;
    }

    public void setWeighted(Double weighted) {
        this.weighted = weighted;
    }

    public Double getTarget() {
        return target;
    }

    public void setTarget(Double target) {
        this.target = target;
    }
}
