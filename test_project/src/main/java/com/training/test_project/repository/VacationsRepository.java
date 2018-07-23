package com.training.test_project.repository;

import com.training.test_project.beans.entity.VacationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationsRepository extends JpaRepository<VacationEntity, Long> {
}
