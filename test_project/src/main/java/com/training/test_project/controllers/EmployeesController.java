package com.training.test_project.controllers;


import com.training.test_project.beans.Employee;
import com.training.test_project.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping("/employee")
    public List<Employee> getEmployee() {
        return employeesRepository.findAll();
    }
}
