package com.ironhack.grades_data_service;

import com.ironhack.grades_data_service.model.Grade;
import com.ironhack.grades_data_service.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class GradesDataServiceApplication implements CommandLineRunner {

    @Autowired
    private GradeRepository gradeRepository;

    public static void main(String[] args) {
        SpringApplication.run(GradesDataServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        gradeRepository.save(new Grade(1L, 1L, "Math", "A"));
        gradeRepository.save(new Grade(2L, 1L, "Science", "B"));
        gradeRepository.save(new Grade(3L, 2L, "Math", "C"));
    }
}
