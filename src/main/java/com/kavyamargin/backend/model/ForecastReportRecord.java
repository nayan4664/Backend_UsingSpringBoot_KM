package com.kavyamargin.backend.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "forecast_reports")
public class ForecastReportRecord extends BaseEntity {

    private String name;
    private String type;
    private String author;
    private LocalDate date;
    private String size;

    public ForecastReportRecord() {
    }

    public ForecastReportRecord(String id, String name, String type, String author, LocalDate date, String size) {
        super(id);
        this.name = name;
        this.type = type;
        this.author = author;
        this.date = date;
        this.size = size;
    }

    public String name() {
        return name;
    }

    public String type() {
        return type;
    }

    public String author() {
        return author;
    }

    public LocalDate date() {
        return date;
    }

    public String size() {
        return size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
