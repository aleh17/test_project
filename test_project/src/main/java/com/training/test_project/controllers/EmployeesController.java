package com.training.test_project.controllers;

import com.training.test_project.beans.dto.Employee;
import com.training.test_project.beans.entity.*;
import com.training.test_project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    VacationsRepository vacationsRepository;

    @GetMapping("/info/{id}")
    public Employee getEmployeeInfo(@PathVariable(value = "id") Long employeeId) {
        return new Employee(employeesRepository.getOne(employeeId));
    }

    @GetMapping("/department/info/{id}")
    public List<Employee> getDepartmentInfo(@PathVariable(value = "id") Long departmentId) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(departmentId);
        return employeesRepository.findByDepartment(departmentEntity).stream().map(Employee::new).collect(toList());
    }

    @PostMapping("/info/update/{id}")
    public Employee updateEmployeeInfo(@Valid @RequestBody Employee employee) {
        DepartmentEntity departmentEntity = departmentRepository.getOne(employee.getDepartment().getId());
        List<VacationEntity> vacations = vacationsRepository.findByEmployeeId(employee.getId());

        return new Employee(
                employeesRepository.save(new EmployeeEntity(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getBirthDate(), employee.getRole(), departmentEntity, employee.getSalary(), employee.getTitle(), vacations, employee.getLogin(), employee.getPassword()))
        );
    }
}
