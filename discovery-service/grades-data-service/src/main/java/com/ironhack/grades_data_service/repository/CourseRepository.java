package com.ironhack.grades_data_service.repository;

import com.ironhack.grades_data_service.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
