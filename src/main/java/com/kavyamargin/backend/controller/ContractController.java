package com.kavyamargin.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kavyamargin.backend.model.ContractRecord;
import com.kavyamargin.backend.repository.ContractRepository;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    private final ContractRepository contractRepository;

    public ContractController(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @GetMapping
    public List<ContractRecord> getAll() {
        return contractRepository.findAll();
    }

    @GetMapping("/{id}")
    public ContractRecord getById(@PathVariable String id) {
        return contractRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contract not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContractRecord create(@RequestBody ContractRecord contractRecord) {
        return contractRepository.save(new ContractRecord(
            null,
            contractRecord.name(),
            contractRecord.client(),
            contractRecord.type(),
            contractRecord.status(),
            contractRecord.uploadDate(),
            contractRecord.renewalDate(),
            contractRecord.complianceScore(),
            contractRecord.owner(),
            contractRecord.summary()
        ));
    }

    @PutMapping("/{id}")
    public ContractRecord update(@PathVariable String id, @RequestBody ContractRecord contractRecord) {
        ensureExists(contractRepository.existsById(id), "Contract not found");
        return contractRepository.save(new ContractRecord(
            id,
            contractRecord.name(),
            contractRecord.client(),
            contractRecord.type(),
            contractRecord.status(),
            contractRecord.uploadDate(),
            contractRecord.renewalDate(),
            contractRecord.complianceScore(),
            contractRecord.owner(),
            contractRecord.summary()
        ));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        ensureExists(contractRepository.existsById(id), "Contract not found");
        contractRepository.deleteById(id);
    }

    private void ensureExists(boolean exists, String message) {
        if (!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }
    }
}
