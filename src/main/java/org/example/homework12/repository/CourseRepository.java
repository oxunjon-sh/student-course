package org.example.homework12.repository;

import org.example.homework12.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

    List<CourseEntity> findByName(String name);

    List<CourseEntity> getByPrice(Double price);

    List<CourseEntity> getByDuration(String duration);

    List<CourseEntity> getByPriceBetween(Double priceDo, Double  priceLet );

    List<CourseEntity> getByCreatedDateBetween(LocalDateTime dateFrom, LocalDateTime dateTo);

}
