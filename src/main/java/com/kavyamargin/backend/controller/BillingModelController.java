package com.kavyamargin.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kavyamargin.backend.model.BillingModelRecord;
import com.kavyamargin.backend.repository.BillingModelRepository;

@RestController
@RequestMapping("/api/billing-models")
public class BillingModelController {

    private final BillingModelRepository billingModelRepository;

    public BillingModelController(BillingModelRepository billingModelRepository) {
        this.billingModelRepository = billingModelRepository;
    }

    @GetMapping
    public List<BillingModelRecord> getAll() {
        return billingModelRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BillingModelRecord create(@RequestBody BillingModelRecord record) {
        return billingModelRepository.save(new BillingModelRecord(
            null,
            record.modelName(),
            record.description(),
            record.rate(),
            record.type()
        ));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        if (!billingModelRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Billing model not found");
        }
        billingModelRepository.deleteById(id);
    }
}
