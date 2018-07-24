package com.training.test_project.beans.dto;

import com.training.test_project.beans.Role;
import com.training.test_project.beans.entity.EmployeeEntity;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class Employee {

    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private Date birthDate;

    private Role role;

    @NotBlank
    private Department department;

    @NotBlank
    private Salary salary;

    @NotBlank
    private Title title;

    private List<Vacation> vacations = new ArrayList<>();

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    public Employee() {
    }

    public Employee(EmployeeEntity employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.birthDate = employee.getBirthDate();
        this.role = employee.getRole();
        this.password = employee.getPassword();
        this.department = new Department(employee.getDepartment().getId(), employee.getDepartment().getDepartmentName());
        this.salary = new Salary(employee.getSalary().getId(), employee.getSalary().getSalary());
        this.title = new Title(employee.getTitle().getId(), employee.getTitle().getTitleName());
        employee.getVacations().forEach(vac -> addVacation(new Vacation(vac)));
    }

    public Employee(Long id, @NotBlank String firstName, @NotBlank String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public List<Vacation> getVacations() {
        return vacations;
    }

    public void setVacations(List<Vacation> vacations) {
        this.vacations = vacations;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addVacation(Vacation vacation) {
        this.vacations.add(vacation);
    }
}
