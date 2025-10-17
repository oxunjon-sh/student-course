package org.example.homework12.repository;

import org.example.homework12.entity.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>, PagingAndSortingRepository<StudentEntity, Integer> {

    List<StudentEntity> findByName(String name);

    List<StudentEntity> getBySurname(String surname);

    List<StudentEntity> getByLevel(String level);

    List<StudentEntity> getByGender(String gender);

    List<StudentEntity> getByAge(Integer age);

    List<StudentEntity> getByCreatedDate(LocalDateTime createdDate);

    List<StudentEntity> getByCreatedDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    Page<StudentEntity> findByAge(Integer age, Pageable pageable);

    @Query("From StudentEntity where age=?1 ")
    Page<StudentEntity> findByAgeWithQuery(Integer age, Pageable pageable);

    @Query(value = "From StudentEntity where age=?1 ", countQuery = "select count(s) from StudentEntity s where s.age = ?1")
    Page<StudentEntity> findByAgeWithQuery2(Integer age, Pageable pageable);

    //

    @Query("From StudentEntity where createdDate between :dateFrom and :dateTo ")
    List<StudentEntity> findStudentDateBetween(@Param("dateFrom") LocalDateTime dateFrom,
                                               @Param("dateTo") LocalDateTime dateTo);



    @Query("From StudentEntity where DATE(createdDate) between :dateFrom and :dateTo ")
    List<StudentEntity> findStudentDateBetween(@Param("dateFrom") LocalDate dateFrom,
                                               @Param("dateTo") LocalDate dateTo);


}
