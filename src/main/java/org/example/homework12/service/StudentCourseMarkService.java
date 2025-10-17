package org.example.homework12.service;

import lombok.RequiredArgsConstructor;
import org.example.homework12.dto.StudentCourseMarkDTO;
import org.example.homework12.entity.StudentCourseMark;
import org.example.homework12.repository.StudentCourseMarkRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentCourseMarkService {
    private final StudentCourseMarkRepository studentCourseMarkRepository;

    public List<StudentCourseMarkDTO> getAllStudentCourseMark() {
        List<StudentCourseMark>  list = studentCourseMarkRepository.findAll();
        List<StudentCourseMarkDTO>  dtoList = new ArrayList<>();
        for (StudentCourseMark studentCourseMark : list) {
            StudentCourseMarkDTO studentCourseMarkDTO = new StudentCourseMarkDTO();
            studentCourseMarkDTO.setId(studentCourseMark.getId());
            studentCourseMarkDTO.setStudentId(studentCourseMark.getStudentId());
            studentCourseMarkDTO.setCourseId(studentCourseMark.getCourseId());
            studentCourseMarkDTO.setMark(studentCourseMark.getMark());
            dtoList.add(studentCourseMarkDTO);
        }
        return dtoList;
    }


    public StudentCourseMarkDTO createStudentCourseMark(StudentCourseMarkDTO studentCourseMarkDTO) {
        return null;
    }

    public Boolean updateStudentCourseMark(Integer id, StudentCourseMarkDTO studentCourseMarkDTO) {
        return null;
    }
}
