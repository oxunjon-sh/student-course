package org.example.homework12.service;

import lombok.RequiredArgsConstructor;
import org.example.homework12.dto.StudentDTO;
import org.example.homework12.entity.StudentEntity;
import org.example.homework12.repository.StudentRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentDTO> getAllStudents() {
        Iterable<StudentEntity> studentEntities = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (StudentEntity entity : studentEntities) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(entity.getId());
            studentDTO.setName(entity.getName());
            studentDTO.setSurname(entity.getSurname());
            studentDTO.setLevel(entity.getLevel());
            studentDTO.setAge(entity.getAge());
            studentDTO.setGender(entity.getGender());
            studentDTO.setCreatedDate(entity.getCreatedDate());
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

    public StudentEntity addStudent(StudentDTO studentDTO) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentDTO.getName());
        studentEntity.setSurname(studentDTO.getSurname());
        studentEntity.setLevel(studentDTO.getLevel());
        studentEntity.setAge(studentDTO.getAge());
        studentEntity.setGender(studentDTO.getGender());
        studentEntity.setCreatedDate(LocalDateTime.now());
        studentRepository.save(studentEntity);
        return studentEntity;
    }

    public StudentDTO getStudentById(Integer id) {
        Optional<StudentEntity> student = Optional.of(studentRepository.getById(id));
        if (student.isPresent()) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(student.get().getId());
            studentDTO.setName(student.get().getName());
            studentDTO.setSurname(student.get().getSurname());
            studentDTO.setLevel(student.get().getLevel());
            studentDTO.setAge(student.get().getAge());
            studentDTO.setGender(student.get().getGender());
            studentDTO.setCreatedDate(student.get().getCreatedDate());
            return studentDTO;
        }
        return null;
    }

    public void updateStudent(StudentDTO studentDTO) {
        for (StudentEntity studentEntity : studentRepository.findAll()) {
            if (studentEntity.getId().equals(studentDTO.getId())) {
                studentRepository.save(studentEntity);
            }
        }
    }

    public Boolean deleteStudent(Integer id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

//    public List<StudentDTO> pagination(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<StudentEntity> studentList = studentRepository.findAll(pageable);
//
//        List<StudentDTO> studentDTOList = new ArrayList<>();
//        for (StudentEntity entity : studentList.getContent()) {
//            StudentDTO studentDTO = new StudentDTO();
//            studentDTO.setId(entity.getId());
//            studentDTO.setName(entity.getName());
//            studentDTO.setSurname(entity.getSurname());
//            studentDTO.setLevel(entity.getLevel());
//            studentDTO.setAge(entity.getAge());
//            studentDTO.setGender(entity.getGender());
//            studentDTO.setCreatedDate(entity.getCreatedDate());
//            studentDTOList.add(studentDTO);
//        }
//        return studentDTOList;
//  }

    public PageImpl<StudentDTO> pagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<StudentEntity> pageResult = studentRepository.findAll(pageable);
        // select * from student order by createdDate desc limit ? offset ?  -> content
        // select count(*) ... totalCount

        List<StudentEntity> studentList = pageResult.getContent();
        long totalElement = pageResult.getTotalElements();

        List<StudentDTO> dtoList = new LinkedList<>();
        for (StudentEntity entity : studentList) {
            StudentDTO dto = new StudentDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setAge(entity.getAge());
            dto.setLevel(entity.getLevel());
            dto.setGender(entity.getGender());
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }

        return new PageImpl<>(dtoList, pageable, totalElement);
    }

    public PageImpl<StudentDTO> findByAgeWithPagination(int age, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<StudentEntity> pageResult = studentRepository.findByAge(age, pageable);
        // select * from student order by createdDate desc limit ? offset ?  -> content
        // select count(*) ... totalCount

        List<StudentEntity> studentList = pageResult.getContent();
        long totalElement = pageResult.getTotalElements();

        List<StudentDTO> dtoList = new LinkedList<>();
        for (StudentEntity entity : studentList) {
            StudentDTO dto = new StudentDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setAge(entity.getAge());
            dtoList.add(dto);
        }

        return new PageImpl<>(dtoList, pageable, totalElement);
    }

    public List<StudentDTO> getStudentByName(String name) {
        List<StudentEntity> optional = studentRepository.findByName(name);
        if (optional.isEmpty()) {
            return null;
        }
        List<StudentDTO> dtoList = new LinkedList<>();
        for (StudentEntity entity : optional) {
            StudentDTO dto = new StudentDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setAge(entity.getAge());
            dto.setGender(entity.getGender());
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<StudentDTO> getStudentBySurname(String surname) {
        List<StudentEntity> optional = studentRepository.getBySurname(surname);
        if (optional.isEmpty()) {
            return null;
        }
        List<StudentDTO> dtoList = new LinkedList<>();
        for (StudentEntity entity : optional) {
            StudentDTO dto = new StudentDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setAge(entity.getAge());
            dto.setGender(entity.getGender());
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<StudentDTO> getStudentByLevel(String level) {
        List<StudentEntity> optional = studentRepository.getByLevel(level);
        if (optional.isEmpty()) {
            return null;
        }
        List<StudentDTO> dtoList = new LinkedList<>();
        for (StudentEntity entity : optional) {
            StudentDTO dto = new StudentDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setAge(entity.getAge());
            dto.setGender(entity.getGender());
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<StudentDTO> findStudentDateBetween(LocalDate dateFrom, LocalDate dateTo) {
        // Studentni berilgan 2kun oralig'idagi olgan baxosi.
        // 2025-01-22 00:00:00   2025-01-28 23:59:59
        // createdDate 2025-01-22 12:55:03
        LocalDateTime createDateFrom = LocalDateTime.of(dateFrom, LocalTime.MIN);
        LocalDateTime createDateTo = LocalDateTime.of(dateTo, LocalTime.MAX);

        List<StudentEntity> studentList = studentRepository.findStudentDateBetween(createDateFrom, createDateTo);
        List<StudentDTO> dtoList = new LinkedList<>();
        for (StudentEntity entity : studentList) {
            StudentDTO dto = new StudentDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setAge(entity.getAge());
            dto.setGender(entity.getGender());
            dto.setCreatedDate(entity.getCreatedDate());
            dto.setLevel(entity.getLevel());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<StudentDTO> findStudentDateBetween2(LocalDate dateFrom, LocalDate dateTo) {
        // Studentni berilgan 2kun oralig'idagi olgan baxosi.
        // 2025-01-22 00:00:00   2025-01-28 23:59:59
        List<StudentEntity> studentList = studentRepository.findStudentDateBetween(dateFrom, dateTo);
        List<StudentDTO> dtoList = new LinkedList<>();
        for (StudentEntity entity : studentList) {
            StudentDTO dto = new StudentDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setAge(entity.getAge());
            dto.setGender(entity.getGender());
            dto.setCreatedDate(entity.getCreatedDate());
            dto.setLevel(entity.getLevel());
            dtoList.add(dto);
        }
        return dtoList;
    }


}
