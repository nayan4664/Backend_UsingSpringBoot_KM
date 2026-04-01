package com.kavyamargin.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class DepartmentRecord extends BaseEntity {

    @Column(name = "department_name")
    private String departmentName;

    private String head;

    @Column(name = "staff_count")
    private Integer staffCount;

    private String budget;

    public DepartmentRecord() {
    }

    public DepartmentRecord(String id, String departmentName, String head, Integer staffCount, String budget) {
        super(id);
        this.departmentName = departmentName;
        this.head = head;
        this.staffCount = staffCount;
        this.budget = budget;
    }

    public String departmentName() {
        return departmentName;
    }

    public String head() {
        return head;
    }

    public Integer staffCount() {
        return staffCount;
    }

    public String budget() {
        return budget;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Integer getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(Integer staffCount) {
        this.staffCount = staffCount;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }
}
