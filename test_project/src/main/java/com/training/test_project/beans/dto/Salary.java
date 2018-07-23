package com.training.test_project.beans.dto;

import com.training.test_project.beans.entity.SalaryEntity;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Salary {

    private Long id;

    private List<Employee> employees = new ArrayList<>();

    @NotBlank
    private BigDecimal salary;

    public Salary() {
    }

    public Salary(SalaryEntity salary) {
        this.id = salary.getId();
        this.salary = salary.getSalary();
        salary.getEmployees().forEach(emp -> addEmployee(new Employee(emp)));
    }

    public Salary(Long id, @NotBlank BigDecimal salary) {
        this.id = id;
        this.salary = salary;
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
}
