package com.ttlecom.springbootelearning.repository;

import com.ttlecom.springbootelearning.entity.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, Integer> {
  List<UserCourse> findByUserId(int id);
  UserCourse findByCourseId(int id);
}
