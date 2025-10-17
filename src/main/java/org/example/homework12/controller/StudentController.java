package org.example.homework12.controller;

import lombok.RequiredArgsConstructor;
import org.example.homework12.dto.StudentDTO;
import org.example.homework12.entity.StudentEntity;
import org.example.homework12.service.StudentService;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }

    @PostMapping("/{id}")
    public ResponseEntity<StudentEntity> addStudent(@PathVariable Integer id,
                                                    @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.addStudent(studentDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }

    @PutMapping
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO) {
        studentService.updateStudent(studentDTO);
        return ResponseEntity.ok().body(studentService.getStudentById(studentDTO.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Integer id) {
        return ResponseEntity.ok().body(studentService.deleteStudent(id));
    }


    @GetMapping("/pagination")
    public ResponseEntity<PageImpl<StudentDTO>> pagination(@RequestParam(value = "page", defaultValue = "1") int page,
                                                           @RequestParam(value = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok(studentService.pagination(page - 1, size));
    }

    @GetMapping("/pagination1")
    public ResponseEntity<PageImpl<StudentDTO>> searchByAge(@RequestParam(value = "page", defaultValue = "1") int page,
                                                            @RequestParam(value = "size", defaultValue = "10") int size,
                                                            @RequestParam(value = "age") int age) {
        return ResponseEntity.ok(studentService.findByAgeWithPagination(age, page - 1, size));
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<StudentDTO>> getStudentByName(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok(studentService.getStudentByName(name));
    }

    @GetMapping("/by-surname")
    public ResponseEntity<List<StudentDTO>> getStudentBySurname(@RequestParam(value = "surname") String surname) {
        return ResponseEntity.ok(studentService.getStudentBySurname(surname));
    }

    @GetMapping("/by-level")
    public ResponseEntity<List<StudentDTO>> getStudentByLevel(@RequestParam(value = "level") String level) {
        return ResponseEntity.ok(studentService.getStudentByLevel(level));
    }

    @GetMapping("/date-between")
    public ResponseEntity<List<StudentDTO>> getStudentByDateBetween(@RequestParam(value = "dateFrom") LocalDate dateFrom,
                                                                    @RequestParam(value = "dateTo") LocalDate localTo) {
        return ResponseEntity.ok(studentService.findStudentDateBetween(dateFrom, localTo));
    }

    @GetMapping("/date-between1")
    public ResponseEntity<List<StudentDTO>> getStudentByDateBetween2(@RequestParam(value = "dateFrom") LocalDate dateFrom,
                                                                     @RequestParam(value = "dateTo") LocalDate dateTo) {
        return ResponseEntity.ok(studentService.findStudentDateBetween2(dateFrom, dateTo));
    }


}
