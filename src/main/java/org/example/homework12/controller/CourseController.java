package org.example.homework12.controller;

import lombok.RequiredArgsConstructor;
import org.example.homework12.dto.CourseDTO;
import org.example.homework12.entity.CourseEntity;
import org.example.homework12.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class  CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseEntity>> getAllCourses(){

        return ResponseEntity.ok().body(courseService.getAllCourse());
    }

    @PostMapping
    public ResponseEntity<CourseDTO> addCourse(@RequestBody CourseDTO courseDTO) {
        return ResponseEntity.ok().body(courseService.addCourse(courseDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Integer id){
        return ResponseEntity.ok().body(courseService.getCourseById(id));
    }

}
