package com.training.test_project.security.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    protected void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "SELECT employees.login as username, employees.password as password, employees.role as role FROM `employees` WHERE employees.login=?")
                .authoritiesByUsernameQuery(
                        "SELECT employees.login as username, employees.password as password, employees.role as role FROM `employees` WHERE employees.login=?")
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //api access
                .antMatchers("/api/departments/**").access("hasRole('TOP_MANAGER')")
                .antMatchers("/api/employees/department**").access("hasAnyRole('TOP_MANAGER','DEPARTMENT_MANAGER')")
                .antMatchers("/api/employees/info/{\\d+}").access("hasAnyRole('TOP_MANAGER','DEPARTMENT_MANAGER','EMPLOYEE')")
                .antMatchers("/api/employees/info/update/**").access("hasRole('TOP_MANAGER')")
                .antMatchers("/api/vacations/request").access("hasRole('EMPLOYEE')")
                .antMatchers("/api/vacations/approve/**").access("hasAnyRole('TOP_MANAGER','DEPARTMENT_MANAGER')")
                .antMatchers("/api/vacations/decline/**").access("hasAnyRole('TOP_MANAGER','DEPARTMENT_MANAGER')")

                //pages access
                .antMatchers("/hello").access("hasRole('TOP_MANAGER')")
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/login")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf();
    }
}
