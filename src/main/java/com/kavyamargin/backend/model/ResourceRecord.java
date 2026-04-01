package com.kavyamargin.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "resources")
public class ResourceRecord extends BaseEntity {

    private String name;
    private String role;

    @Column(name = "primary_skill")
    private String primarySkill;

    @Column(name = "secondary_skill")
    private String secondarySkill;

    @Column(name = "proficiency_level")
    private String proficiencyLevel;

    @Column(name = "experience_years")
    private Integer experienceYears;

    @Column(name = "current_project")
    private String currentProject;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "availability_percentage")
    private Integer availabilityPercentage;

    @Column(name = "allocation_percentage")
    private Integer allocationPercentage;

    private String department;

    public ResourceRecord() {
    }

    public ResourceRecord(String id, String name, String role, String primarySkill, String secondarySkill, String proficiencyLevel,
            Integer experienceYears, String currentProject, String releaseDate, Integer availabilityPercentage,
            Integer allocationPercentage, String department) {
        super(id);
        this.name = name;
        this.role = role;
        this.primarySkill = primarySkill;
        this.secondarySkill = secondarySkill;
        this.proficiencyLevel = proficiencyLevel;
        this.experienceYears = experienceYears;
        this.currentProject = currentProject;
        this.releaseDate = releaseDate;
        this.availabilityPercentage = availabilityPercentage;
        this.allocationPercentage = allocationPercentage;
        this.department = department;
    }

    public String name() {
        return name;
    }

    public String role() {
        return role;
    }

    public String primarySkill() {
        return primarySkill;
    }

    public String secondarySkill() {
        return secondarySkill;
    }

    public String proficiencyLevel() {
        return proficiencyLevel;
    }

    public Integer experienceYears() {
        return experienceYears;
    }

    public String currentProject() {
        return currentProject;
    }

    public String releaseDate() {
        return releaseDate;
    }

    public Integer availabilityPercentage() {
        return availabilityPercentage;
    }

    public Integer allocationPercentage() {
        return allocationPercentage;
    }

    public String department() {
        return department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPrimarySkill() {
        return primarySkill;
    }

    public void setPrimarySkill(String primarySkill) {
        this.primarySkill = primarySkill;
    }

    public String getSecondarySkill() {
        return secondarySkill;
    }

    public void setSecondarySkill(String secondarySkill) {
        this.secondarySkill = secondarySkill;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(String proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(String currentProject) {
        this.currentProject = currentProject;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getAvailabilityPercentage() {
        return availabilityPercentage;
    }

    public void setAvailabilityPercentage(Integer availabilityPercentage) {
        this.availabilityPercentage = availabilityPercentage;
    }

    public Integer getAllocationPercentage() {
        return allocationPercentage;
    }

    public void setAllocationPercentage(Integer allocationPercentage) {
        this.allocationPercentage = allocationPercentage;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
