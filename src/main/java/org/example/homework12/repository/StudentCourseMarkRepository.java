package org.example.homework12.repository;
import org.example.homework12.entity.StudentCourseMarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseMarkRepository extends JpaRepository<StudentCourseMarkEntity, Integer> {
}
