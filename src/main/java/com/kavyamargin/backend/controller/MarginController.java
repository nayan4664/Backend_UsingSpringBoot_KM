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

import com.kavyamargin.backend.model.MarginRecord;
import com.kavyamargin.backend.repository.MarginRepository;

@RestController
@RequestMapping("/api/margins")
public class MarginController {

    private final MarginRepository marginRepository;

    public MarginController(MarginRepository marginRepository) {
        this.marginRepository = marginRepository;
    }

    @GetMapping
    public List<MarginRecord> getAll() {
        return marginRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MarginRecord create(@RequestBody MarginRecord marginRecord) {
        return marginRepository.save(new MarginRecord(
            null,
            marginRecord.projectName(),
            marginRecord.clientName(),
            marginRecord.revenue(),
            marginRecord.cost(),
            marginRecord.grossMargin(),
            marginRecord.netMargin(),
            marginRecord.targetMargin(),
            marginRecord.month()
        ));
    }

    @PutMapping("/{id}")
    public MarginRecord update(@PathVariable String id, @RequestBody MarginRecord marginRecord) {
        ensureExists(marginRepository.existsById(id), "Margin record not found");
        return marginRepository.save(new MarginRecord(
            id,
            marginRecord.projectName(),
            marginRecord.clientName(),
            marginRecord.revenue(),
            marginRecord.cost(),
            marginRecord.grossMargin(),
            marginRecord.netMargin(),
            marginRecord.targetMargin(),
            marginRecord.month()
        ));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        ensureExists(marginRepository.existsById(id), "Margin record not found");
        marginRepository.deleteById(id);
    }

    private void ensureExists(boolean exists, String message) {
        if (!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }
    }
}
