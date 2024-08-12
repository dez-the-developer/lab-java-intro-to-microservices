package com.ironhack.student_info_service;

import com.ironhack.student_info_service.model.Student;
import com.ironhack.student_info_service.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class StudentInfoServiceApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentInfoServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentRepository.save(new Student(1L, "John Doe"));
        studentRepository.save(new Student(2L, "Jane Smith"));
    }
}
