package com.kavyamargin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavyamargin.backend.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
}
