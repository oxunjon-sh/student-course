package org.example.homework12.repository;

import org.example.homework12.entity.StudentCourseMark;
import org.example.homework12.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseMarkRepository extends JpaRepository<StudentCourseMark, Integer> {
}
