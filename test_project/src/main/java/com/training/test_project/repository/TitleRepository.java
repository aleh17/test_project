package com.training.test_project.repository;

import com.training.test_project.beans.entity.TitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<TitleEntity, Long> {
}
