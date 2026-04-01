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

import com.kavyamargin.backend.model.Employee;
import com.kavyamargin.backend.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable String id) {
        return employeeRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee) {
        return employeeRepository.save(new Employee(
            null,
            employee.name(),
            employee.role(),
            employee.department(),
            employee.CTC(),
            employee.monthlyCost(),
            employee.email(),
            employee.joiningDate(),
            employee.variablePay(),
            employee.location()
        ));
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee) {
        ensureExists(employeeRepository.existsById(id), "Employee not found");
        return employeeRepository.save(new Employee(
            id,
            employee.name(),
            employee.role(),
            employee.department(),
            employee.CTC(),
            employee.monthlyCost(),
            employee.email(),
            employee.joiningDate(),
            employee.variablePay(),
            employee.location()
        ));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        ensureExists(employeeRepository.existsById(id), "Employee not found");
        employeeRepository.deleteById(id);
    }

    private void ensureExists(boolean exists, String message) {
        if (!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }
    }
}
