package com.kavyamargin.backend.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(nullable = false, updatable = false, length = 36)
    private String id;

    protected BaseEntity() {
    }

    protected BaseEntity(String id) {
        this.id = id;
    }

    @PrePersist
    protected void assignIdIfMissing() {
        if (id == null || id.isBlank()) {
            id = UUID.randomUUID().toString();
        }
    }

    public String id() {
        return id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
