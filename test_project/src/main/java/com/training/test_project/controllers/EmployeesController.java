package com.training.test_project.controllers;


import com.training.test_project.beans.dto.Employee;
import com.training.test_project.beans.entity.EmployeeEntity;
import com.training.test_project.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping("/employee")
    public List<Employee> getEmployee() {
        return employeesRepository.findAll().stream().map(Employee::new).collect(Collectors.toList());
    }
}
