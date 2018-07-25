package com.training.test_project.security.service;

import com.training.test_project.beans.dto.Employee;

public interface EmployeeService {

    Employee findEmployeeByLogin(String email);
    void saveEmployee(Employee employee);
}
