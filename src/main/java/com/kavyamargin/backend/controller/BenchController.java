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

import com.kavyamargin.backend.model.BenchResource;
import com.kavyamargin.backend.repository.BenchRepository;

@RestController
@RequestMapping("/api/bench")
public class BenchController {

    private final BenchRepository benchRepository;

    public BenchController(BenchRepository benchRepository) {
        this.benchRepository = benchRepository;
    }

    @GetMapping
    public List<BenchResource> getAll() {
        return benchRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BenchResource create(@RequestBody BenchResource benchResource) {
        return benchRepository.save(new BenchResource(
            null,
            benchResource.name(),
            benchResource.role(),
            benchResource.bench_duration_weeks(),
            benchResource.cost_impact(),
            benchResource.primary_skill(),
            benchResource.status()
        ));
    }

    @PutMapping("/{id}")
    public BenchResource update(@PathVariable String id, @RequestBody BenchResource benchResource) {
        ensureExists(benchRepository.existsById(id), "Bench resource not found");
        return benchRepository.save(new BenchResource(
            id,
            benchResource.name(),
            benchResource.role(),
            benchResource.bench_duration_weeks(),
            benchResource.cost_impact(),
            benchResource.primary_skill(),
            benchResource.status()
        ));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        ensureExists(benchRepository.existsById(id), "Bench resource not found");
        benchRepository.deleteById(id);
    }

    private void ensureExists(boolean exists, String message) {
        if (!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }
    }
}
