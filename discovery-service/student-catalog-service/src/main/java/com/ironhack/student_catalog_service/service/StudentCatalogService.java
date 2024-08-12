package com.ironhack.student_catalog_service.service;

import com.ironhack.student_catalog_service.model.StudentCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class StudentCatalogService {

    @Autowired
    private RestTemplate restTemplate;

    public StudentCatalog getStudentCatalog(Long studentId) {
        String studentInfoUrl = "http://student-info-service/students/" + studentId;
        String gradesDataUrl = "http://grades-data-service/grades/" + studentId;

        StudentCatalog studentCatalog = new StudentCatalog();
        studentCatalog.setStudentId(studentId);

        // Fetching student info
        Student studentInfo = restTemplate.getForObject(studentInfoUrl, Student.class);
        if (studentInfo != null) {
            studentCatalog.setStudentName(studentInfo.getName());
        }

        // Fetching grades info
        StudentDetails[] studentGrades = restTemplate.getForObject(gradesDataUrl, StudentDetails[].class);
        if (studentGrades != null) {
            studentCatalog.setCourses(Arrays.stream(studentGrades).map(StudentDetails::getCourse).toList());
            studentCatalog.setGrades(Arrays.stream(studentGrades).map(StudentDetails::getGrade).toList());
        }

        return studentCatalog;
    }
}
