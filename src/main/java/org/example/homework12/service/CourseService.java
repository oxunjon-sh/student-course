package org.example.homework12.service;
import lombok.RequiredArgsConstructor;
import org.example.homework12.dto.CourseDTO;
import org.example.homework12.entity.CourseEntity;
import org.example.homework12.repository.CourseRepository;
import org.springframework.stereotype.Service;
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
}
