package org.example.homework12.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StudentDTO {

    private Integer id;

    private String name;

    private String surname;

    private Integer age;

    private String level;

    private String gender;

    private LocalDateTime createdDate;
}
