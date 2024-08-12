package com.ironhack.grades_data_service.controller;

import com.ironhack.grades_data_service.model.Grade;
import com.ironhack.grades_data_service.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeRepository gradeRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long id) {
        return gradeRepository.findById(id)
                .map(grade -> ResponseEntity.ok(grade))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    @PostMapping
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeRepository.save(grade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grade> updateGrade(@PathVariable Long id, @RequestBody Grade gradeDetails) {
        return gradeRepository.findById(id)
                .map(grade -> {
                    grade.setGrade(gradeDetails.getGrade());
                    grade.setStudentId(gradeDetails.getStudentId());
                    grade.setCourseId(gradeDetails.getCourseId());
                    Grade updatedGrade = gradeRepository.save(grade);
                    return ResponseEntity.ok(updatedGrade);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
        return gradeRepository.findById(id)
                .map(grade -> {
                    gradeRepository.delete(grade);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
