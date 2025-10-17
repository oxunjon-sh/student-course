package org.example.homework12.service;

import lombok.RequiredArgsConstructor;
import org.example.homework12.dto.CourseDTO;
import org.example.homework12.entity.CourseEntity;
import org.example.homework12.repository.CourseRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<CourseEntity> getAllCourse() {
        return courseRepository.findAll();
    }

    public CourseDTO addCourse(CourseDTO courseDTO) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(courseDTO.getId());
        courseEntity.setName(courseDTO.getName());
        courseEntity.setDuration(courseDTO.getDuration());
        courseEntity.setPrice(courseDTO.getPrice());
        courseEntity.setCreatedDate(courseDTO.getCreatedDate());
        courseRepository.save(courseEntity);
        return courseDTO;
    }

    public CourseDTO getCourseById(Integer id) {
        Optional<CourseEntity> courseEntity = courseRepository.findById(id);
        if (courseEntity.isEmpty()) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(courseEntity.get().getId());
        courseDTO.setName(courseEntity.get().getName());
        courseDTO.setDuration(courseEntity.get().getDuration());
        courseDTO.setPrice(courseEntity.get().getPrice());
        courseDTO.setCreatedDate(courseEntity.get().getCreatedDate());
        return courseDTO;
    }

    public Boolean deleteCourseById(Integer id) {
        Optional<CourseEntity> courseEntity = courseRepository.findById(id);
        if (courseEntity.isEmpty()) {
            return false;
        }
        courseRepository.deleteById(id);
        return true;
    }

    public Boolean updateCourse(Integer id, CourseDTO courseDTO) {
        Optional<CourseEntity> courseEntity = courseRepository.findById(id);
        if (courseEntity.isEmpty()) {
            return false;
        }
        CourseEntity entity = courseEntity.get();
        entity.setName(courseDTO.getName());
        entity.setDuration(courseDTO.getDuration());
        entity.setPrice(courseDTO.getPrice());
        entity.setCreatedDate(courseDTO.getCreatedDate());
        courseRepository.save(entity);
        return true;
    }

    public PageImpl<CourseDTO> getCourseWithPagination(Integer page, Integer size) {
        Pageable   pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<CourseEntity> pageResult = courseRepository.findAll(pageable);
        List<CourseEntity> courseList = pageResult.getContent();
        long totalElement = pageResult.getTotalElements();
        List<CourseDTO> courseDTOList = new ArrayList<>();

        for (CourseEntity entity : courseList) {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setName(entity.getName());
            courseDTO.setPrice(entity.getPrice());
            courseDTO.setDuration(entity.getDuration());
            courseDTO.setCreatedDate(entity.getCreatedDate());
            courseDTOList.add(courseDTO);
        }
        return new PageImpl<>(courseDTOList, pageable, totalElement);
    }
}
