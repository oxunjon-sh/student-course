package org.example.homework12.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StudentCourseMarkDTO {

    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private String mark;
    private LocalDateTime createdDate;
}
