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

import com.kavyamargin.backend.model.ResourceRecord;
import com.kavyamargin.backend.repository.ResourceRepository;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    private final ResourceRepository resourceRepository;

    public ResourceController(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @GetMapping
    public List<ResourceRecord> getAll() {
        return resourceRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResourceRecord create(@RequestBody ResourceRecord resourceRecord) {
        return resourceRepository.save(new ResourceRecord(
            null,
            resourceRecord.name(),
            resourceRecord.role(),
            resourceRecord.primarySkill(),
            resourceRecord.secondarySkill(),
            resourceRecord.proficiencyLevel(),
            resourceRecord.experienceYears(),
            resourceRecord.currentProject(),
            resourceRecord.releaseDate(),
            resourceRecord.availabilityPercentage(),
            resourceRecord.allocationPercentage(),
            resourceRecord.department()
        ));
    }

    @PutMapping("/{id}")
    public ResourceRecord update(@PathVariable String id, @RequestBody ResourceRecord resourceRecord) {
        ensureExists(resourceRepository.existsById(id), "Resource not found");
        return resourceRepository.save(new ResourceRecord(
            id,
            resourceRecord.name(),
            resourceRecord.role(),
            resourceRecord.primarySkill(),
            resourceRecord.secondarySkill(),
            resourceRecord.proficiencyLevel(),
            resourceRecord.experienceYears(),
            resourceRecord.currentProject(),
            resourceRecord.releaseDate(),
            resourceRecord.availabilityPercentage(),
            resourceRecord.allocationPercentage(),
            resourceRecord.department()
        ));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        ensureExists(resourceRepository.existsById(id), "Resource not found");
        resourceRepository.deleteById(id);
    }

    private void ensureExists(boolean exists, String message) {
        if (!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }
    }
}
