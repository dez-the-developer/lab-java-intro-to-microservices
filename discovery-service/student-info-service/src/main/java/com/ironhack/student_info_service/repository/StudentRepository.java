package com.ironhack.student_info_service.repository;

import com.ironhack.student_info_service.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
