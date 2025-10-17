package org.example.homework12.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    private String level;

    private Integer age;

    private String gender;

    private LocalDateTime createdDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<StudentCourseMark> marks;
}
