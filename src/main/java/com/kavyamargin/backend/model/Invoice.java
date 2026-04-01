package com.kavyamargin.backend.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoices")
public class Invoice extends BaseEntity {

    @Column(name = "invoice_id")
    private String invoiceId;

    @Column(name = "client_name")
    private String clientName;

    private String project;
    private LocalDate date;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "invoice_items", joinColumns = @JoinColumn(name = "invoice_record_id"))
    @OrderColumn(name = "item_order")
    private List<InvoiceItem> items = new ArrayList<>();

    @Column(name = "tax_rate")
    private Double taxRate;

    @Column(length = 4000)
    private String notes;

    private String status;

    public Invoice() {
    }

    public Invoice(String id, String invoiceId, String clientName, String project, LocalDate date, LocalDate dueDate,
            List<InvoiceItem> items, Double taxRate, String notes, String status) {
        super(id);
        this.invoiceId = invoiceId;
        this.clientName = clientName;
        this.project = project;
        this.date = date;
        this.dueDate = dueDate;
        this.items = items == null ? new ArrayList<>() : new ArrayList<>(items);
        this.taxRate = taxRate;
        this.notes = notes;
        this.status = status;
    }

    public String invoiceId() {
        return invoiceId;
    }

    public String clientName() {
        return clientName;
    }

    public String project() {
        return project;
    }

    public LocalDate date() {
        return date;
    }

    public LocalDate dueDate() {
        return dueDate;
    }

    public List<InvoiceItem> items() {
        return items;
    }

    public Double taxRate() {
        return taxRate;
    }

    public String notes() {
        return notes;
    }

    public String status() {
        return status;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items == null ? new ArrayList<>() : new ArrayList<>(items);
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
