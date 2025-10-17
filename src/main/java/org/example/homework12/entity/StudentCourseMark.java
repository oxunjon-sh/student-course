package org.example.homework12.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "student_course")
public class StudentCourseMark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer studentId;
    private Integer courseId;
    private String mark;
    private LocalDateTime createdDate;
}
