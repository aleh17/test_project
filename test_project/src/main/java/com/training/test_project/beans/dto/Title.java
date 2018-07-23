package com.training.test_project.beans.dto;

import com.training.test_project.beans.entity.TitleEntity;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class Title {

    private Long id;

    private List<Employee> employees = new ArrayList<>();

    @NotBlank
    private String titleName;

    public Title() {
    }

    public Title(TitleEntity title) {
        this.id = title.getId();
        this.titleName = title.getTitleName();
        title.getEmployees().forEach(emp -> addEmployee(new Employee(emp)));
    }

    public Title(Long id, @NotBlank String titleName) {
        this.id = id;
        this.titleName = titleName;
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

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
}
