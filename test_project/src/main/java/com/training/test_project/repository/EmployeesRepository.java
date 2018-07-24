package com.training.test_project.repository;

import com.training.test_project.beans.entity.DepartmentEntity;
import com.training.test_project.beans.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findByDepartment(DepartmentEntity department);
}
