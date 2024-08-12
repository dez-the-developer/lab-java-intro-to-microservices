package com.ironhack.student_catalog_service.controller;

import com.ironhack.student_catalog_service.model.StudentCatalog;
import com.ironhack.student_catalog_service.service.StudentCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
public class StudentCatalogController {

    @Autowired
    private StudentCatalogService studentCatalogService;

    @GetMapping("/{studentId}")
    public StudentCatalog getStudentCatalog(@PathVariable Long studentId) {
        return studentCatalogService.getStudentCatalog(studentId);
    }
}
