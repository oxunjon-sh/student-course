package org.example.homework12.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "course")
@Getter
@Setter
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double price;

    private String duration;

    private LocalDateTime createdDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<StudentCourseMark> marks;
}
