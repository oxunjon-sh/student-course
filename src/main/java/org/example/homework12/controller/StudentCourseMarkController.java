package org.example.homework12.controller;

import lombok.RequiredArgsConstructor;
import org.example.homework12.dto.StudentCourseMarkDTO;
import org.example.homework12.service.StudentCourseMarkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-course")
@RequiredArgsConstructor
public class StudentCourseMarkController {

    private final StudentCourseMarkService studentCourseMarkService;

    @GetMapping
    public ResponseEntity<List<StudentCourseMarkDTO>> findAll() {
        return ResponseEntity.ok(studentCourseMarkService.getAllStudentCourseMark());
    }
    @PostMapping
    public ResponseEntity<StudentCourseMarkDTO>  createStudentCourseMark(@RequestBody StudentCourseMarkDTO studentCourseMarkDTO) {
        return  ResponseEntity.ok(studentCourseMarkService.createStudentCourseMark(studentCourseMarkDTO));
    }

    @PutMapping
    public ResponseEntity<Boolean> updateStudentCourseMark(@PathVariable Integer id,
                                                           @RequestBody StudentCourseMarkDTO studentCourseMarkDTO) {
        return ResponseEntity.ok(studentCourseMarkService.updateStudentCourseMark(id,studentCourseMarkDTO));
    }
}
