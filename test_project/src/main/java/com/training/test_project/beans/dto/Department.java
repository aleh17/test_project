package com.training.test_project.beans.dto;

import com.training.test_project.beans.entity.DepartmentEntity;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class Department {

    private Long id;

    private List<Employee> employees = new ArrayList<>();

    @NotBlank
    private String departmentName;

    public Department() {
    }

    public Department(DepartmentEntity entity) {
        this.id = entity.getId();
        this.departmentName = entity.getDepartmentName();
        entity.getEmployees().forEach(emp -> addEmployee(new Employee(emp)));
    }

    public Department(Long id, @NotBlank String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
}
