package com.training.test_project.security.service;

import com.training.test_project.beans.dto.Employee;
import com.training.test_project.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeesRepository employeesRepository;

    @Override
    public Employee findEmployeeByLogin(String login) {
        return employeesRepository.findByLogin(login);
    }

    @Override
    public void saveEmployee(Employee employee) {

    }
}
