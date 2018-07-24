package com.training.test_project.controllers;

import com.training.test_project.beans.dto.Department;
import com.training.test_project.beans.entity.DepartmentEntity;
import com.training.test_project.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {

    @Autowired
    DepartmentRepository departmentRepository;

    @PostMapping("/create")
    public Department requestVacation(@Valid @RequestBody Department department) {
        return new Department(
                departmentRepository.save(new DepartmentEntity(department.getId(), department.getDepartmentName()))
        );
    }
}
