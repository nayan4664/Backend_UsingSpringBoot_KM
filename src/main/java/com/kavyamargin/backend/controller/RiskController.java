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

import com.kavyamargin.backend.model.RiskRecord;
import com.kavyamargin.backend.repository.RiskRepository;

@RestController
@RequestMapping("/api/risks")
public class RiskController {

    private final RiskRepository riskRepository;

    public RiskController(RiskRepository riskRepository) {
        this.riskRepository = riskRepository;
    }

    @GetMapping
    public List<RiskRecord> getAll() {
        return riskRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RiskRecord create(@RequestBody RiskRecord riskRecord) {
        return riskRepository.save(new RiskRecord(
            null,
            riskRecord.title(),
            riskRecord.category(),
            riskRecord.severity(),
            riskRecord.impact(),
            riskRecord.mitigation(),
            riskRecord.status()
        ));
    }

    @PutMapping("/{id}")
    public RiskRecord update(@PathVariable String id, @RequestBody RiskRecord riskRecord) {
        ensureExists(riskRepository.existsById(id), "Risk not found");
        return riskRepository.save(new RiskRecord(
            id,
            riskRecord.title(),
            riskRecord.category(),
            riskRecord.severity(),
            riskRecord.impact(),
            riskRecord.mitigation(),
            riskRecord.status()
        ));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        ensureExists(riskRepository.existsById(id), "Risk not found");
        riskRepository.deleteById(id);
    }

    private void ensureExists(boolean exists, String message) {
        if (!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }
    }
}
