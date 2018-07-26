package com.training.test_project.security.service;

import com.training.test_project.beans.entity.EmployeeEntity;
import com.training.test_project.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeService implements UserDetailsService {

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        EmployeeEntity employeeEntity = employeesRepository.findByLogin(login);

        User.UserBuilder userBuilder = null;
        if (employeeEntity != null) {
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(login);
            userBuilder.password(employeeEntity.getPassword());
            userBuilder.roles(employeeEntity.getRole().toString());
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return userBuilder.build();
    }
}
