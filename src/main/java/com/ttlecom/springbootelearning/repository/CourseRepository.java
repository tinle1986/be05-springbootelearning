package com.ttlecom.springbootelearning.repository;

import com.ttlecom.springbootelearning.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

  Course findByTitle(String title);

}
