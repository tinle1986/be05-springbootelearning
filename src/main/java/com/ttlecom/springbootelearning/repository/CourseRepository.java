package com.ttlecom.springbootelearning.repository;

import com.ttlecom.springbootelearning.dto.CourseDto;
import com.ttlecom.springbootelearning.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

  Course findByTitle(String title);

  @Query("SELECT new com.ttlecom.springbootelearning.dto.CourseDto(c.id, c.title, ca.title, c.content, c.description, c.image, c.hourCount, c.lectureCount, c.price, c.discount, c.viewCount, c.promotionPrice, c.lastUpdate) FROM Course c JOIN c.category ca")
  List<CourseDto> getAllDto();
}
