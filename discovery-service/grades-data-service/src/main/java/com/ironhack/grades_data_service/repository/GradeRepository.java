package com.ironhack.grades_data_service.repository;

import com.ironhack.grades_data_service.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
