package com.training.test_project.security.config;
import com.training.test_project.beans.Role;
import com.training.test_project.security.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public UserDetailsService userDetailsService() {
        return new EmployeeService();
    }

    @Autowired
    protected void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/departments/create").hasRole(Role.TOP_MANAGER.toString())
                .antMatchers("/api/employees/department/info/{\\d+}").hasAnyRole(Role.TOP_MANAGER.toString(), Role.DEPARTMENT_MANAGER.toString())
                .antMatchers("/api/employees/info/{\\d+}").hasAnyRole(Role.TOP_MANAGER.toString(), Role.DEPARTMENT_MANAGER.toString(), Role.EMPLOYEE.toString())
                .antMatchers("/api/employees/info/update/{\\d+}").hasRole(Role.TOP_MANAGER.toString())
                .antMatchers("/api/vacations/request").hasRole(Role.EMPLOYEE.toString())
                .antMatchers("/api/vacations/approve/{\\d+}").hasAnyRole(Role.TOP_MANAGER.toString(), Role.DEPARTMENT_MANAGER.toString())
                .antMatchers("/api/vacations/decline/{\\d+}").hasAnyRole(Role.TOP_MANAGER.toString(), Role.DEPARTMENT_MANAGER.toString())
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }
}
